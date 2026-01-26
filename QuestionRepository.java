package org.example.repository;

import org.example.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * The interface Question repository.
 */
public interface QuestionRepository extends JpaRepository<Question, Integer> {


    /**
     * Ruft eine zufällige Auswahl an Fragen aus der Datenbank ab welche durch das Attrobuts amount die ANzahl Fragn angibt
     * * Diese Methode nutzt eine native SQL-Abfrage mit ORDER BY RAND(),
     * um die Datensätze zu mischen und die Anzahl der Ergebnisse zu begrenzen.
     *
     * @param amount Die maximale Anzahl der zufällig auszuwählenden Fragen.
     * @return Eine Liste von zufällig ausgewählten {@link Question}-Objekten.
     */
    @Query(value = "SELECT * FROM question ORDER BY RAND() LIMIT :amount", nativeQuery = true)
    List<Question> findRandomQuestions(@Param("amount") int amount);



}

