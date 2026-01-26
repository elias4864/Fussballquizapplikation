package org.example.service;

import org.example.model.Team;
import org.example.repository.LeagueRepository;
import org.example.repository.TeamRepository;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * Service Anniotatu damit Spring Boot die Service Klasse erkennt
 */
@Service
public class TeamService {


    /**
     * Depdeny Incetions zur Repostiroy und League Repository KLasse welche
     */

    private final TeamRepository teamRepository;
    private final LeagueRepository leagueRepository;

    /**
     * Instantiates a new Team service.
     *
     * @param teamRepository   the team repository
     * @param leagueRepository the league repository
     */
    public TeamService(TeamRepository teamRepository, LeagueRepository leagueRepository) {
        this.teamRepository = teamRepository;
        this.leagueRepository = leagueRepository;
    }


    /**
     * Gets team.
     *
     * @param id the id
     * @return the team
     */
    public Team getTeam(Integer id) {
        return teamRepository.findById(id).orElse(null);
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    /**
     * Create team team.
     *
     * @param team the team
     * @return the team
     */
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    /**
     * Delete team.
     *
     * @param id the id
     */
    public void deleteTeam(Integer id) {
        teamRepository.deleteById(id);
    }
}
