package com.note.note.controller;

import com.note.note.models.Note;
import com.note.note.services.NoteService;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    NoteService noteService;


    @GetMapping("/patient/{patientId}")
    public ResponseEntity<?> getNotesByPatient(@PathVariable("patientId") int patientId) {
        try {
            List<Note> notes = noteService.getNotesByPatient(patientId);
            notes.forEach(System.out::println);
            return ResponseEntity.ok(notes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while fetching notes for patient with ID: " + patientId);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNote(@PathVariable("id") String id) {

        return ResponseEntity.ok(noteService.getNoteById(id));

    }

    @PostMapping("/add/{id}")
    public ResponseEntity<?> addNote(@RequestBody Note note,@PathVariable("id") int id) {
        try {
            Note savedNote = noteService.saveNote(note,id);
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
    public ResponseEntity<?> deleteNote(@PathVariable("id") String id) {
        try {
            noteService.deleteNote(id);
            return ResponseEntity.ok("Note with ID " + id + " deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while deleting the note with ID: " + id);
        }
    }
}
