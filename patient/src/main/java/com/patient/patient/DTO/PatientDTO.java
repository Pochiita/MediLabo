package com.patient.patient.DTO;

import com.patient.patient.models.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class PatientDTO {

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
