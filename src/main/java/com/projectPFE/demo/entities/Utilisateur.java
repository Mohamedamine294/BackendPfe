package com.projectPFE.demo.entities;

import com.projectPFE.demo.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "utilisateur")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(nullable = false, length = 100)
    private String prenom;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "mot_de_passe", nullable = false)
    private String motDePasse;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(name = "date_inscription")
    private LocalDate dateInscription = LocalDate.now();

    @Column(name = "est_actif")
    private Boolean estActif = true;

    @OneToOne(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private EtudiantBaccalaureat etudiantBac;

    @OneToOne(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private EtudiantLicence etudiantLicence;

    @OneToOne(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private Entreprise entreprise;

    @OneToOne(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private Administrateur administrateur;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<ResultatTest> resultats;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<ConversationIA> conversations;
}