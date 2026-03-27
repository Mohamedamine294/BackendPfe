package com.projectPFE.demo.repositories;

import com.projectPFE.demo.entities.ResultatTest;
import com.projectPFE.demo.enums.TypeRecommandation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ResultatTestRepository
        extends JpaRepository<ResultatTest, Long> {

    List<ResultatTest> findByUtilisateurId(Long utilisateurId);
    List<ResultatTest> findByTypeRecommandation(
            TypeRecommandation type);
    List<ResultatTest> findByUtilisateurIdOrderByDatePassageDesc(
            Long utilisateurId);
}