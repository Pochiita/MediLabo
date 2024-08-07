package com.note.note.models;

import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Data
@Document("notes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Note {
    @Id
    @GeneratedValue
    private Integer id;
    private int patientId;
    @NotNull
    private String note;
    private Date date;

}
