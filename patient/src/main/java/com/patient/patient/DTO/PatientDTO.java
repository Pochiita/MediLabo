package com.patient.patient.DTO;

import com.patient.patient.models.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PatientDTO {

    @Id
    int id;

    @NotNull(message = "Firstname cannot be null")
    @NotEmpty(message = "Firstname cannot be empty")
    @NotBlank(message = "Firstname cannot be blank")
    String firstname;

    @NotNull(message = "Lastname cannot be null")
    @NotEmpty(message = "Lastname cannot be empty")
    @NotBlank(message = "Lastname cannot be blank")
    String lastname;

    @NotNull(message = "Birthdate cannot be null")
    @PastOrPresent(message = "Birthdate must be in the past or present")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate bd;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Gender cannot be null")
    Gender gender;

    String address;

    String phone;
}
