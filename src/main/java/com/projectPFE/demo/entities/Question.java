package com.projectPFE.demo.entities;

import com.projectPFE.demo.enums.TypeQuestion;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "question")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String enonce;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeQuestion type;

    @Column(nullable = false)
    private Integer ordre;

    @OneToMany(mappedBy = "question",
            cascade = CascadeType.ALL)
    private List<OptionReponse> options;
}