package com.projectPFE.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.util.Map;

@Entity
@Table(name = "option_reponse")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OptionReponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String libelle;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "points_attribues",
            columnDefinition = "jsonb")
    private Map<String, Integer> pointsAttribues;
}