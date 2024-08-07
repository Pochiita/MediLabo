package com.note.note.controller;

import com.note.note.models.Note;
import com.note.note.services.NoteService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    NoteService noteService;


    @GetMapping("/patient/{patientId}")
    public ResponseEntity<?> getNotesByPatient(@PathVariable("patientId") int patientId) {
        try {
            List<Note> notes = noteService.getNotesByPatient(patientId);
            return ResponseEntity.ok(notes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while fetching notes for patient with ID: " + patientId);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNote(@PathVariable("id") int id) {

        return ResponseEntity.ok(noteService.getNoteById(id));

    }

    @PostMapping("/add")
    public ResponseEntity<?> addNote(@RequestBody Note note) {
        try {
            Note savedNote = noteService.saveNote(note);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedNote);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while saving the note");
        }
    }

    @PutMapping("/modify")
    public ResponseEntity<?> modifyNote(@RequestBody Note note) {
        try {
            Note updatedNote = noteService.updateNote(note);
            return ResponseEntity.ok(updatedNote);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while updating the note");
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable("id") int id) {
        try {
            noteService.deleteNote(id);
            return ResponseEntity.ok("Note with ID " + id + " deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while deleting the note with ID: " + id);
        }
    }
}
