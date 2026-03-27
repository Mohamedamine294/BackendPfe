package com.projectPFE.demo.repositories;

import com.projectPFE.demo.entities.EtudiantBaccalaureat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface EtudiantBaccalaureatRepository
        extends JpaRepository<EtudiantBaccalaureat, Long> {

    Optional<EtudiantBaccalaureat> findByUtilisateurId(
            Long utilisateurId);
}