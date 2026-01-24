package org.example.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.model.Player;
import org.example.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PlayerService {


    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void deleteCategory(Integer id) {
        // Überprüfen, ob die Kategorie existiert, bevor man löscht
        if (playerRepository.existsById(id)) {
            playerRepository.deleteById(id);
        }
    }



    public Player updatePlayer(Integer id, Player player) {
        return playerRepository.findById(id)
                .map(p -> {
                    player.setFirstName(player.getFirstName());
                    player.setLastName(player.getLastName());
                    player.setBirthYear(player.getBirthYear());
                    player.setPosition(player.getPosition());
                    player.setNationality(player.getNationality());
                    player.setStats(player.getStats());
                    player.setIsactive(player.isIsactive());
                    player.setTeam(player.getTeam());
                    // Wichtig: Falls Fragen verknüpft sind, hier ebenfalls setzen
                    return playerRepository.save(player);
                })
                .orElseGet(() -> {
                    player.setId(id);
                    return playerRepository.save(player);
                });
    }



    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public List<Player> findByStats(String stats){
        return playerRepository.findByStats(stats);
    }

    public List<Player> findByNationality(String nationality) {
        return playerRepository.findByNationality(nationality);
    }
    public Player getPlayer(int id) {
        return playerRepository.findById(id)
                .orElse(null); // oder throw new RuntimeException("...");
    }



    public List<Player> getActivePlayers() {
        return playerRepository.findByisactive(true);
    }


    public List<Player> getInActivePlayers() {
        return playerRepository.findByisactive(false);
    }



}

