package com.projectPFE.demo.entities;

import com.projectPFE.demo.enums.NiveauEtudes;
import com.projectPFE.demo.enums.StatutOffre;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "offre_stage")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OffreStage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "entreprise_id", nullable = false)
    private Entreprise entreprise;

    @Column(nullable = false)
    private String titre;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 255)
    private String localisation;

    @Column(name = "duree_stage", length = 100)
    private String dureeStage;

    @Enumerated(EnumType.STRING)
    @Column(name = "niveau_requis")
    private NiveauEtudes niveauRequis;

    @Column(name = "date_publication")
    private LocalDate datePublication = LocalDate.now();

    @Column(name = "date_expiration")
    private LocalDate dateExpiration;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutOffre statut = StatutOffre.EN_ATTENTE;

    @ManyToMany
    @JoinTable(
            name = "offre_stage_competence",
            joinColumns = @JoinColumn(name = "offre_stage_id"),
            inverseJoinColumns = @JoinColumn(name = "competence_id")
    )
    private Set<Competence> competences;
}