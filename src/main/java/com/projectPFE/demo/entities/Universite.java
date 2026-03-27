package com.projectPFE.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "universite")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Universite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(length = 100)
    private String ville;

    @Column(length = 100)
    private String pays = "Tunisie";

    @Column(name = "site_web")
    private String siteWeb;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "universite",
            cascade = CascadeType.ALL)
    private List<Filiere> filieres;

    @OneToMany(mappedBy = "universite",
            cascade = CascadeType.ALL)
    private List<ProgrammeMaster> masters;
}