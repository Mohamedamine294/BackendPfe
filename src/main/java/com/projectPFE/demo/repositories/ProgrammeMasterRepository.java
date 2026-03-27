package com.projectPFE.demo.repositories;

import com.projectPFE.demo.entities.ProgrammeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProgrammeMasterRepository
        extends JpaRepository<ProgrammeMaster, Long> {

    List<ProgrammeMaster> findByUniversiteId(Long universiteId);
    List<ProgrammeMaster> findBySpecialiteContaining(
            String specialite);
}