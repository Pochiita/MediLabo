package com.front.front.proxies;

import com.front.front.DTO.NoteDTO;
import com.front.front.models.Note;
import org.bson.types.ObjectId;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "note", url="http://localhost:8090/notes")
public interface NoteProxy {

    @GetMapping("/patient/{patientId}")
    ResponseEntity<List<Note>> getNotesByPatient(@PathVariable("patientId") int patientId);

    @GetMapping("/{id}")
    ResponseEntity<Note> getNote(@PathVariable("id") ObjectId id);
    @PostMapping("/add/{id}")
    ResponseEntity<Note> addNote(@RequestBody NoteDTO note, @PathVariable("id") int id);

    @PutMapping("/modify")
    ResponseEntity<Note> modifyNote(@RequestBody Note note);

    @GetMapping("/delete/{id}")
    ResponseEntity<String> deleteNote(@PathVariable("id") ObjectId id);
}