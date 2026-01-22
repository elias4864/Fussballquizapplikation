package org.example.repository;

import org.example.model.League;
import org.example.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team,Integer> {

    List<Team> findByLeague(League league);


    List<Team> findByLeagueName(@Param("leagueName") String leagueName);

    // Benutzerdefinierte Abfrage mit JOIN
    List<Team> findByLeagueId(@Param("leagueId") String leagueId);
}
