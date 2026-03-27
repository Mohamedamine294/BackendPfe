package com.projectPFE.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "filiere")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Filiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "universite_id", nullable = false)
    private Universite universite;

    @Column(nullable = false)
    private String nom;

    private Integer duree;

    @Column(name = "type_formation", length = 100)
    private String typeFormation;

    @Column(name = "conditions_admission",
            columnDefinition = "TEXT")
    private String conditionsAdmission;

    @Column(columnDefinition = "text[]")
    private List<String> debouches;

    @Column(name = "frais_inscription")
    private Double fraisInscription;
}