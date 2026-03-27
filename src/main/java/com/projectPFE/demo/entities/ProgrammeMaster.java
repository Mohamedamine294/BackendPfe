package com.projectPFE.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "programme_master")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgrammeMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "universite_id", nullable = false)
    private Universite universite;

    @Column(nullable = false)
    private String nom;

    @Column(length = 255)
    private String specialite;

    private Integer duree;

    @Column(name = "conditions_admission",
            columnDefinition = "TEXT")
    private String conditionsAdmission;

    @Column(columnDefinition = "text[]")
    private List<String> debouches;
}