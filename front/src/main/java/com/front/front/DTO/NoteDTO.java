package com.front.front.DTO;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NoteDTO {
    @Id
    private Integer id;
    private int patientId;
    @NotNull
    @NotBlank
    private String note;

}
