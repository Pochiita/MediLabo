package com.patient.patient.models;

import com.patient.patient.models.Gender;
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
public class Patient {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String firstname;

    @Column(nullable = false)
    String lastname;

    @Column(nullable = false)
    String bd;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    Gender gender;

    @Column(nullable = true)
    String address;

    @Column(nullable = true)
    String phone;
}
