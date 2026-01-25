package org.example.service;

import org.example.model.League;
import org.example.repository.LeagueRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LeagueService  {

    /**
     * Leagueverwalting
     * Dependency Injection zu League Repository  alle benötigten  Methoden welche für den League Controller werden initalisiert
     */
    private final LeagueRepository leagueRepository;

    public LeagueService(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    public League existsById(String id) {
        return leagueRepository.findById(id).orElse(null);
    }

    public League findByName(String name) {
        return leagueRepository.findByName(name);  // Gibt League oder null zurück
    }

    public League create(League league) {
        return leagueRepository.save(league);
    }

    public void delete(String id) {
        leagueRepository.deleteById(id);
    }

}
