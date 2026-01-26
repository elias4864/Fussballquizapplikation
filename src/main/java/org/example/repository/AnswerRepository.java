package org.example.repository;

import org.example.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * Schnittstelle welche HTPTS Request  welche alle für die Antworten defineirten Methoden dwie die vo JPA bereitgesteletl findbyQuestionId anhan der Primary Key quesitonId  definiert
 */
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    /**
     * Find by question id list.
     *
     * @param questionId the question id
     * @return the list
     */
    List<Answer> findByQuestionId(Integer questionId);
}
