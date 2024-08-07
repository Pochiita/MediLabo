package com.front.front.controller;

import com.front.front.DTO.NoteDTO;
import com.front.front.models.Note;
import com.front.front.proxies.NoteProxy;
import com.front.front.proxies.PatientProxy;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/notes")
public class NoteController {

    private final NoteProxy noteProxy;

    public NoteController(PatientProxy patientProxy, NoteProxy noteProxy) {
        this.noteProxy = noteProxy;
    }


    @GetMapping("/single/add/{id}")
    public String createNotePage(Model model,@PathVariable("id") int id){
        NoteDTO note = new NoteDTO();
        model.addAttribute("note",note);
        model.addAttribute("patientId",id);
        return "addNote";
    }

    @PostMapping("/single/add/process/{id}")
    public String createNoteProcess (@Valid @ModelAttribute("note") NoteDTO noteDTO, BindingResult results, Model model, @PathVariable("id") int id){
        if (results.hasErrors() || results.hasFieldErrors()){
            model.addAttribute("note",noteDTO);
            return "addNote";
        }
        try {
            ResponseEntity<?> response = noteProxy.addNote(noteDTO,id);
            return "redirect:/patients/single/"+id;
        }catch(Exception e) {
            model.addAttribute("errorAddingNote",true);
            return "redirect:/patients/single/"+id;
        }
    }

    @GetMapping("/single/modify/{id}")
    public String modifyNotePage(Model model,@PathVariable("id") String noteId){
        try {
            ResponseEntity<Note> response = noteProxy.getNote(noteId);
            model.addAttribute("note",response.getBody());
            return "modifyNote";
        }catch(Exception e) {
            model.addAttribute("notFindable",true);
            return "modifyNote";
        }
    }

    @PostMapping("/single/modify/process/{id}")
    public String modifyNoteProcess (@Valid @ModelAttribute("patient")Note note,@PathVariable("id") String id, BindingResult results,Model model){
        if (results.hasErrors() || results.hasFieldErrors()){
            model.addAttribute("note",note);
            return "modifyNote";
        }


        try {
            ResponseEntity<Note> baseNote = noteProxy.getNote(id);
            note.setPatientId(baseNote.getBody().getPatientId());
            note.setDate(baseNote.getBody().getDate());
            ResponseEntity<?> response = noteProxy.modifyNote(note);
            return "redirect:/patients/single/"+note.getPatientId();
        }catch(Exception e) {
            model.addAttribute("errorNote",true);
            return "redirect:/patients/single/modify/"+note.getPatientId();
        }
    }

    @GetMapping("/single/delete/process/{id}")
    public String deleteNoteProcess (@PathVariable("id") String id,Model model) {
        try {
            ResponseEntity<Note> toDelete = noteProxy.getNote(id);
            ResponseEntity<?> response = noteProxy.deleteNote(id);
            return "redirect:/patients/single/"+toDelete.getBody().getPatientId();
        }catch(Exception e) {
            model.addAttribute("notDeletableNote",true);
            return "redirect:/patients/";
        }
    }
}
