package com.front.front.DTO;

import com.front.front.models.Gender;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {

    @GeneratedValue
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
    @NotEmpty
    @NotBlank

    String bd;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull
    Gender gender;

    @Column(nullable = true)
    String address;

    @Column(nullable = true)
    String phone;
}
