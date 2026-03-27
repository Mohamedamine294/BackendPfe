package com.projectPFE.demo.repositories;

import com.projectPFE.demo.entities.OffreStage;
import com.projectPFE.demo.enums.NiveauEtudes;
import com.projectPFE.demo.enums.StatutOffre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OffreStageRepository
        extends JpaRepository<OffreStage, Long> {

    List<OffreStage> findByStatut(StatutOffre statut);
    List<OffreStage> findByEntrepriseId(Long entrepriseId);
    List<OffreStage> findByNiveauRequis(NiveauEtudes niveau);
    List<OffreStage> findByStatutAndNiveauRequis(
            StatutOffre statut, NiveauEtudes niveau);
}