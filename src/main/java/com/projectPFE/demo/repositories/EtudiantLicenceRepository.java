package com.projectPFE.demo.repositories;

import com.projectPFE.demo.entities.EtudiantLicence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface EtudiantLicenceRepository
        extends JpaRepository<EtudiantLicence, Long> {

    Optional<EtudiantLicence> findByUtilisateurId(
            Long utilisateurId);
}