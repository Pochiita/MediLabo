package com.patient.patient.DTO;

import com.patient.patient.models.Gender;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patient")
public class patientDTO {

    @GeneratedValue
    @Id
    int id;

    @Column(nullable = false)
    @NotNull
    @NotEmpty
    String firstname;

    @Column(nullable = false)
    @NotNull
    @NotEmpty
    String lastname;

    @Column(nullable = false)
    @NotNull
    @NotEmpty
    String bd;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull
    @NotEmpty
    Gender gender;

    @Column(nullable = true)
    String address;

    @Column(nullable = true)
    String phone;






}
