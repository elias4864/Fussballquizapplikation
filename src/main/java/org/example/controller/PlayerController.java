package org.example.controller;

import org.example.model.Player;
import org.example.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {



@Autowired
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public List<Player> getPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Player getById(@PathVariable int id) {
        return playerService.getPlayer(id);
    }

    @GetMapping("/active")
    public List<Player> findByIsActiveTrue() {
        return playerService.getActivePlayers();
    }



    @GetMapping("/inactive")
    public List<Player> findByIsActiveFalse() {
        return playerService.getInactivePlayers()   ;
    }




    @GetMapping("/addplayer")
    public Player createPlayer(@RequestBody Player player) {
        // Speichert den Spieler, der als JSON im Request-Body gesendet wird
        return  playerService.addPlayer(player);
    }

    @GetMapping("/nationality/{nationality}")
    public List<Player> getPlayersByNationality(@PathVariable String nationality) {
        return playerService.findByNationality(nationality);
    }


}
