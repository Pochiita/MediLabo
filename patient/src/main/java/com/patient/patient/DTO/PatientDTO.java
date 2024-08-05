package com.patient.patient.DTO;

import com.patient.patient.models.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PatientDTO {

    int id;

    @NotNull
    @NotEmpty
    String firstname;

    @NotNull
    @NotEmpty
    String lastname;

    @NotNull
    @NotEmpty
    String bd;

    @Enumerated(EnumType.STRING)
    @NotNull
    @NotEmpty
    Gender gender;

    String address;

    String phone;
}
