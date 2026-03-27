package com.projectPFE.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "entreprise")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Entreprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "utilisateur_id",
            nullable = false, unique = true)
    private Utilisateur utilisateur;

    @Column(name = "nom_entreprise", nullable = false)
    private String nomEntreprise;

    @Column(name = "secteur_activite")
    private String secteurActivite;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "site_web")
    private String siteWeb;

    @Column(length = 500)
    private String logo;

    @Column(name = "est_validee")
    private Boolean estValidee = false;

    @OneToMany(mappedBy = "entreprise",
            cascade = CascadeType.ALL)
    private List<OffreStage> offres;
}