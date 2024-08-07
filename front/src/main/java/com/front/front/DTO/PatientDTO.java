package com.front.front.DTO;

import com.front.front.models.Gender;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @Column(nullable = false)
    @NotNull
    @NotEmpty
    @NotBlank
    String firstname;

    @Column(nullable = false)
    @NotNull
    @NotEmpty
    @NotBlank

    String lastname;

    @Column(nullable = false)
    @NotNull
    @PastOrPresent
    LocalDate bd;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull
    Gender gender;

    @Column(nullable = true)
    String address;

    @Column(nullable = true)
    String phone;
}
