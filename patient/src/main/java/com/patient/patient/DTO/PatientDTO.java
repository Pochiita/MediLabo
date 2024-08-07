package com.patient.patient.DTO;

import com.patient.patient.models.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PatientDTO {

    private int id;

    @NotNull
    @NotEmpty
    private String firstname;

    @NotNull
    @NotEmpty
    private String lastname;

    @NotNull
    @PastOrPresent
    private LocalDate bd;

    @Enumerated(EnumType.STRING)
    @NotNull
    @NotEmpty
    private Gender gender;

    private String address;

    private String phone;
}
