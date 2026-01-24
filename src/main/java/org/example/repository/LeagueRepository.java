package org.example.repository;

import org.example.model.League;
import org.example.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LeagueRepository extends JpaRepository<League, String> {

    /**
     * Methode welche eine Liga anhand seines Nanens atribut ausliest
     * @param name
     * @return
     */
    League findByName(String name);  // korrekte Schreibweise (mit Großbuchstabe B)

    /**
     * Eine bestimmter  League Datensatz wird mit der vorderfinierten findById Methode ausgelesen
     * @param id
     * @return League
     */
    Optional<League> findById(@Param("id") String id);

    /**
     *Eine Liga Datensatz wird wird anhand des Attributs name also namen der Liga ausgelesen
     * @param name
     * @return List<League>
     */

    List<League> findAllByName(String name);



}
