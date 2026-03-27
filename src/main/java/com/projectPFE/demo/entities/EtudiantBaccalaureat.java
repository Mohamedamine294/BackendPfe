package com.projectPFE.demo.entities;

import com.projectPFE.demo.enums.TypeBac;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "etudiant_bac")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EtudiantBaccalaureat {

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

    @Enumerated(EnumType.STRING)
    @Column(name = "type_bac")
    private TypeBac typeBac;

    @Column(name = "moyenne_bac")
    private Double moyenneBac;

    @Column(name = "matieres_fortes",
            columnDefinition = "text[]")
    private List<String> matieresFortes;

    @Column(name = "region_preferee", length = 100)
    private String regionPreferee;

    @ManyToMany
    @JoinTable(
            name = "etudiant_bac_universite",
            joinColumns = @JoinColumn(name = "etudiant_bac_id"),
            inverseJoinColumns = @JoinColumn(name = "universite_id")
    )
    private Set<Universite> universites;

    @ManyToMany
    @JoinTable(
            name = "etudiant_bac_filiere",
            joinColumns = @JoinColumn(name = "etudiant_bac_id"),
            inverseJoinColumns = @JoinColumn(name = "filiere_id")
    )
    private Set<Filiere> filieres;
}