package org.example.service;

import org.example.model.League;
import org.example.repository.LeagueRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * The type League service.
 */
@Service
public class LeagueService  {

    /**
     * Leagueverwalting
     * Dependency Injection zu League Repository  alle benötigten  Methoden welche für den League Controller werden initalisiert
     */
    private final LeagueRepository leagueRepository;

    /**
     * Instantiates a new League service.
     *
     * @param leagueRepository the league repository
     */
    public LeagueService(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    /**
     * Exists by id league.
     *
     * @param id the id
     * @return the league
     */
    public League existsById(String id) {
        return leagueRepository.findById(id).orElse(null);
    }

    /**
     * Find by name league.
     *
     * @param name the name
     * @return the league
     */
    public League findByName(String name) {
        return leagueRepository.findByName(name);  // Gibt League oder null zurück
    }

    /**
     * Create league.
     *
     * @param league the league
     * @return the league
     */
    public League create(League league) {
        return leagueRepository.save(league);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    public void delete(String id) {
        leagueRepository.deleteById(id);
    }

}
