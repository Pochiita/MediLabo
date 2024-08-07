package com.note.note.repository;

import com.note.note.models.Note;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends MongoRepository <Note, String> {
    List<Note> findByPatientId (int patientId);
}
