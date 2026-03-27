package com.projectPFE.demo.repositories;

import com.projectPFE.demo.entities.ConversationIA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ConversationIARepository
        extends JpaRepository<ConversationIA, Long> {

    List<ConversationIA> findByUtilisateurId(Long utilisateurId);
    List<ConversationIA> findByUtilisateurIdOrderByDateDebutDesc(
            Long utilisateurId);
}