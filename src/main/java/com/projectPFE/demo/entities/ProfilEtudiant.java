package com.projectPFE.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class ProfilEtudiant {

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

    public abstract String getTypeOrientation();
}