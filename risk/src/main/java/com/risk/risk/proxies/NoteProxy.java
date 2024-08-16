package com.risk.risk.proxies;

import com.risk.risk.models.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="note",url = "http://gateway:8090/notes")
public interface NoteProxy {

    @GetMapping("/patient/{patientId}")
    ResponseEntity<List<Note>> getNotesByPatient(@PathVariable("patientId") int patientId);
}
