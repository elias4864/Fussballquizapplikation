package org.example.service;

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

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }


    public List<Player> findByNationality(String nationality) {
        return playerRepository.findByNationality(nationality);
    }
    public Player getPlayer(int id) {
        return playerRepository.findById(id)
                .orElse(null); // oder throw new RuntimeException("...");
    }



    public List<Player> getActivePlayers() {
        return playerRepository.findByIsactiveTrue();
    }

    public List<Player> getInactivePlayers() {
        return playerRepository.findByIsactiveFalse();
    }



}

