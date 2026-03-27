package com.projectPFE.demo.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "metier")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Metier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "salaire_moyen")
    private Double salaireMoyen;

    @Column(name = "etudes_requises",
            columnDefinition = "TEXT")
    private String etudesRequises;

    @Column(name = "perspectives_embauche",
            columnDefinition = "TEXT")
    private String perspectivesEmbauche;

    @Column(name = "famille_metier", length = 100)
    private String familleMetier;
}