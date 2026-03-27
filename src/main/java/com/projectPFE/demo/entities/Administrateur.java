package com.projectPFE.demo.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "administrateur")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Administrateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "utilisateur_id",
            nullable = false, unique = true)
    private Utilisateur utilisateur;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(nullable = false, unique = true)
    private String email;
}