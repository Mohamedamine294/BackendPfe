package com.projectPFE.demo.repositories;

import com.projectPFE.demo.entities.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FiliereRepository
        extends JpaRepository<Filiere, Long> {

    List<Filiere> findByUniversiteId(Long universiteId);
    List<Filiere> findByTypeFormation(String typeFormation);
}