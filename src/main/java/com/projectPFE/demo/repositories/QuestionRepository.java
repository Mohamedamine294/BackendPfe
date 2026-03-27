package com.projectPFE.demo.repositories;

import com.projectPFE.demo.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuestionRepository
        extends JpaRepository<Question, Long> {

    List<Question> findByQuizIdOrderByOrdreAsc(Long quizId);
}