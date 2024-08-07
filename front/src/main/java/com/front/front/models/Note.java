package com.front.front.models;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.bson.types.ObjectId;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Note {

    private String id;
    private int patientId;
    @NotNull
    @NotBlank
    private String note;
    private Date date;
}