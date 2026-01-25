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

    public TeamService(TeamRepository teamRepository, LeagueRepository leagueRepository) {
        this.teamRepository = teamRepository;
        this.leagueRepository = leagueRepository;
    }



    public Team getTeam(Integer id) {
        return teamRepository.findById(id).orElse(null);
    }

    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public void deleteTeam(Integer id) {
        teamRepository.deleteById(id);
    }
}
