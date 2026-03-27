package com.projectPFE.demo.repositories;

import com.projectPFE.demo.entities.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface EntrepriseRepository
        extends JpaRepository<Entreprise, Long> {

    Optional<Entreprise> findByUtilisateurId(Long utilisateurId);
    List<Entreprise> findByEstValidee(Boolean estValidee);
}