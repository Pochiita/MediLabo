package com.patient.patient.models;

import com.patient.patient.models.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    @NotNull
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private LocalDate bd;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = true)
    private String address;

    @Column(nullable = true)
    private String phone;
}
