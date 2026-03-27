package com.projectPFE.demo.entities;

import com.projectPFE.demo.enums.TypeQuiz;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "quiz")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titre;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_quiz", nullable = false)
    private TypeQuiz typeQuiz;

    @Column(name = "date_creation")
    private LocalDate dateCreation = LocalDate.now();

    @Column(name = "est_actif")
    private Boolean estActif = true;

    @OneToMany(mappedBy = "quiz",
            cascade = CascadeType.ALL)
    @OrderBy("ordre ASC")
    private List<Question> questions;
}