package com.front.front.proxies;

import com.front.front.models.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "note", url="http://localhost:8090/notes")
public interface NoteProxy {

    @GetMapping("/patient/{patientId}")
    ResponseEntity<List<Note>> getNotesByPatient(@PathVariable("patientId") int patientId);

    @GetMapping("/{id}")
    ResponseEntity<Note> getNote(@PathVariable("id") int id);
    @PostMapping("/add")
    ResponseEntity<Note> addNote(@RequestBody Note note);

    @PutMapping("/modify")
    ResponseEntity<Note> modifyNote(@RequestBody Note note);

    @GetMapping("/delete/{id}")
    ResponseEntity<String> deleteNote(@PathVariable("id") int id);
}