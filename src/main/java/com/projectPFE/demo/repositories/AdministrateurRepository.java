package com.projectPFE.demo.repositories;

import com.projectPFE.demo.entities.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AdministrateurRepository
        extends JpaRepository<Administrateur, Long> {

    Optional<Administrateur> findByUtilisateurId(Long utilisateurId);
    Optional<Administrateur> findByEmail(String email);
}