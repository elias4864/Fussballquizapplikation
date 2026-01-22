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


    //Player Liste ausgeben
    @PostMapping("/players")
    public List<Player> getPlayers() {
        return playerService.getAllPlayers();
    }
    //Player byId
    @GetMapping("/{id}")
    public Player getById(@PathVariable int id) {
        return playerService.getPlayer(id);
    }

    //** ALle Aktiven SPieler
    @GetMapping("/active")
    public List<Player> findByIsActiveTrue() {
        return playerService.getActivePlayers();
    }


        //Alle Inaktiven Spieler anzeigen
    @GetMapping("/inactive")
    public List<Player> findByIsActiveFalse() {
        return playerService.getInactivePlayers()   ;
    }



    //Neuen Spieler der Player Tabelle hinzufügen
    @PostMapping ("/addplayer")
    public Player createPlayer(@RequestBody Player player) {
        // Speichert den Spieler, der als JSON im Request-Body gesendet wird
        return  playerService.addPlayer(player);
    }
        //Neien Spieler nach Nationalität suchen
    @GetMapping("/nationality/{nationality}")
    public List<Player> getPlayersByNationality(@PathVariable String nationality) {
        return playerService.findByNationality(nationality);
    }


}
