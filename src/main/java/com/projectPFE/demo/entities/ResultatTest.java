package com.projectPFE.demo.entities;

import com.projectPFE.demo.enums.TypeRecommandation;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "resultat_test")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultatTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;

    @Column(name = "date_passage")
    private LocalDateTime datePassage = LocalDateTime.now();

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "score_par_famille",
            columnDefinition = "jsonb")
    private Map<String, Integer> scoreParFamille;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_recommandation")
    private TypeRecommandation typeRecommandation;

    @ManyToMany
    @JoinTable(
            name = "resultat_metier",
            joinColumns = @JoinColumn(name = "resultat_test_id"),
            inverseJoinColumns = @JoinColumn(name = "metier_id")
    )
    private Set<Metier> metiersRecommandes;
}