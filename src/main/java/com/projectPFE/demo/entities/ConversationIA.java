package com.projectPFE.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "conversation_ia")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConversationIA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    @Column(name = "date_debut")
    private LocalDateTime dateDebut = LocalDateTime.now();

    @Column(columnDefinition = "TEXT")
    private String contexte;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private List<String> historique;

    @Column(name = "modele_ia", length = 100)
    private String modeleIA = "gpt-4";
}
