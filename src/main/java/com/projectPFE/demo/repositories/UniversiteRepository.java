package com.projectPFE.demo.repositories;

import com.projectPFE.demo.entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UniversiteRepository
        extends JpaRepository<Universite, Long> {

    List<Universite> findByVille(String ville);
    List<Universite> findByPays(String pays);
}