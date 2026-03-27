package com.projectPFE.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "etudiant_licence")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EtudiantLicence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "utilisateur_id",
            nullable = false, unique = true)
    private Utilisateur utilisateur;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    @Column(length = 100)
    private String ville;

    @Column(length = 20)
    private String telephone;

    @Column(name = "traits_personnalite",
            columnDefinition = "text[]")
    private List<String> traitsPersonnalite;

    @Column(columnDefinition = "text[]")
    private List<String> passions;

    @Column(name = "specialite_licence")
    private String specialiteLicence;

    @Column(length = 255)
    private String etablissement;

    @Column(name = "annee_obtention")
    private Integer anneeObtention;

    @Column(name = "moyenne_licence")
    private Double moyenneLicence;

    @ManyToMany
    @JoinTable(
            name = "etudiant_licence_master",
            joinColumns = @JoinColumn(
                    name = "etudiant_licence_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "master_id")
    )
    private Set<ProgrammeMaster> masters;

    @ManyToMany
    @JoinTable(
            name = "etudiant_licence_offre",
            joinColumns = @JoinColumn(
                    name = "etudiant_licence_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "offre_stage_id")
    )
    private Set<OffreStage> offresConsultees;
}