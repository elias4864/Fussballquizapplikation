package org.example.repository;

import org.example.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {


    /**
     * Zufällige Fragen
     * @param amount
     * @return
     */
    @Query(value = "SELECT * FROM question ORDER BY RAND() LIMIT :amount", nativeQuery = true)
    List<Question> findRandomQuestions(@Param("amount") int amount);

}

