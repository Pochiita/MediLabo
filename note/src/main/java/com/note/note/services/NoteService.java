package com.note.note.services;

import com.note.note.models.Note;
import com.note.note.repository.NoteRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> getNotesByPatient(int id) {
        try {
            return noteRepository.findByPatientId(id);
        } catch (Exception e) {
            throw new RuntimeException("Unable to retrieve notes for patient with ID " + id, e);
        }
    }

    public Note getNoteById(String id){
        try {
            return noteRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Note not found for ID " + id));
        } catch (Exception e) {
            throw new RuntimeException("Unable to retrieve notes for patient with ID " + id, e);
        }
    }

    public Note saveNote(Note note,int id) {
        System.out.println(note.getId());
        try {
            note.setDate(new Date());
            note.setPatientId(id);
            System.out.println(note.getId());
            return noteRepository.save(note);
        } catch (Exception e) {
            System.out.println("hello");
            throw new RuntimeException("Unable to save note", e);
        }
    }

    public Note updateNote(Note note) {
        try {
            return noteRepository.save(note);
        } catch (Exception e) {
            throw new RuntimeException("Unable to update note", e);
        }
    }

    public void deleteNote(String id) {
        try {
            noteRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Unable to delete note with ID " + id, e);
        }
    }
}
