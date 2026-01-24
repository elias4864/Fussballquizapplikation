package org.example.repository;

import org.example.model.League;
import org.example.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team,Integer> {

    /**
     * Findet alle Teams mit einer bestimmten Liga-Entitiät
     * @param league
     * @return Bestimmte Liste von Teams in einer Liga
     */
    List<Team> findByLeague(League league);

    /**
     *Ein Team wird anahnd des Atributs leagueName also einer zugehörigen Liga ausgelesen wird
     * @param leagueName
     * @return  Neue Liste names Team aller Fussballteams welcher zu einer anhand der Paramteres leagueName zugehröigen Liga angehören wird  zurückgegeben
     */


    List<Team> findByLeagueName(@Param("leagueName") String leagueName);

    /**
     * Eine Liste eines Teams welcher zu der Id einer bestimmten Liga gehören wird durch den leagueid ausgelesen
     * @param leagueId
     * @return Eine Liste von Teams, die zu einer Liga-ID gehören
     */


    List<Team> findByLeagueId(@Param("leagueId") String leagueId);
}
