package org.example.repository;

import org.example.model.League;
import org.example.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LeagueRepository extends JpaRepository<League, String> {


    League findByName(String name);  // korrekte Schreibweise (mit Großbuchstabe B)
    Optional<League> findLById(@Param("id") String id);

    List<League> findAllByName(String name);



}
