package org.example.controller;


import org.example.model.Player;
import org.example.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


// 2. Spring Web Annotationen
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
/**
 * The type Player controller.
 */
@RestController
@RequestMapping("/players")
@CrossOrigin(origins = "http://localhost:5173")

public class PlayerController {


    /**
     *     * ALle für die PlayerController benötigten Methoden w sowie alle bentögiten Methoden des Repository Interfaces werden initialisiert
     */
    private final PlayerService playerService;

    /**
     * Konstruktor für Dependency Injection.
     *
     * @param playerService Der Service für die Spieler-Logik.
     */
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    /**
     * Ruft eine Liste aller registrierten Spieler ab.
     *
     * @return Liste aller Spieler.
     */
    @GetMapping("/all")
    public List<Player> getPlayers() {
        return playerService.getAllPlayers();
    }

    /**
     * Ruft alle derzeit aktiven Spieler ab.
     *
     * @return Liste aktiver Spieler.
     */
    @GetMapping("/active")
    public List<Player> getActivePlayers() {
        return playerService.getActivePlayers();
    }


    /**
     * Ein SPieler anhand des Priamry Keys id wird aufgerfut und  sien Spielerinfromtioen werden angezeigt
     *
     * @param id the id
     * @return Player mit bestimmter Id
     */
    @GetMapping("/player/{id}")
    public Player getPlayerById(@PathVariable int id) {
        // Ruft den Service auf, der das Repository nutzt
        return playerService.getPlayer(id);
    }

    /**
     * Ruft alle inaktiven Spieler ab.
     *
     * @return Eine neue Liste Player inaktiver Spieler werden angeigt die die Statusaktivität "inaktiv" haben @
     */
    @GetMapping("/inactive")
    public List<Player> getInactivePlayers() {
        return playerService.getInActivePlayers();
    }

    /**
     * Erstellt einen neuen Spieler-Datensatz
     * @param player Das Spieler-Objekt, das im Request-Body gesendet wird
     * @return der gespeicherte Player inklusiver generierter ID
     */
    /**
     * Erstellt einen neuen Spieler-Datensatz.
     *
     * @param player the player
     * @return the response entity
     */
    @PostMapping("/add") // Entferne das /{player}
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        Player savedPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);
    }


    /**
     * Update player response entity.
     *
     * @param id            the id
     * @param playerDetails the player details
     * @return the response entity
     */

    /**
     * Sucht Spieler basierend auf ihrer Nationalität.
     *
     * @param nationality Die Nationalität als Pfad-Variable (z.B. /nationality/German).
     * @return Eine Liste von Spielern der entsprechenden Nationalität.
     */
    @GetMapping("/nationality/{nationality}")
    public List<Player> getPlayersByNationality(@PathVariable String nationality) {
        return playerService.findByNationality(nationality);
    }

    /**
     * Sucht Spieler basierend auf einem Statistik-Kriterium.
     *
     * @param stats Das Statistik-Kriterium als Pfad-Variable.
     * @return List Player Eine Liste von Spielern, die das Kriterium erfüllen.
     */
    @GetMapping("/stats/{stats}")
    public List<Player> getPlayersByStats(@PathVariable String stats) {
        return playerService.findByStats(stats);
    }


    /**
     * Ein Spieler mit einem bestimen VOrnamen wir anhand der PathVariabel firstName entfernt
     *
     * @param firstName the first name
     * @return Player
     */
    @DeleteMapping("/delete/name/{firstName}")
    public ResponseEntity<String> deletePlayer(@PathVariable String firstName) {
        playerService.deletePlayer(firstName);
        return ResponseEntity.ok("Der Spieler mit dem Vornamen " + firstName + " wurde gelöscht.");
    }
}

