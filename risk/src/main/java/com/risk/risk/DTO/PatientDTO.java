package com.risk.risk.DTO;

import com.risk.risk.models.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {

    @Id
    int id;
    @NotNull
    @NotEmpty
    @NotBlank
    String firstname;


    @NotNull
    @NotEmpty
    @NotBlank

    String lastname;

    @NotNull
    @PastOrPresent
    LocalDate bd;

    @Enumerated(EnumType.STRING)
    @NotNull
    Gender gender;

    String address;

    String phone;
}
