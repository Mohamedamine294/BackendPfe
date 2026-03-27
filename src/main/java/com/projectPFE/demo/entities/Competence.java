package com.projectPFE.demo.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "competence")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Competence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(length = 100)
    private String categorie;
}