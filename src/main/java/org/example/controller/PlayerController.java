package org.example.controller;

import org.example.model.Player;
import org.example.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {


    /**
     *     * ALle für die PlayerController benötigten Methoden w sowie alle bentögiten Methoden des Repository Interfaces werden initialisiert
     */
    private final PlayerService playerService;

    /**
     * Konstruktor für Dependency Injection.
     * @param playerService Der Service für die Spieler-Logik.
     */
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    /**
     * Ruft eine Liste aller registrierten Spieler ab.
     * @return Liste aller Spieler.
     */
    @GetMapping("/all")
    public List<Player> getPlayers() {
        return playerService.getAllPlayers();
    }

    /**
     * Ruft alle derzeit aktiven Spieler ab.
     * @return Liste aktiver Spieler.
     */
    @GetMapping("/active")
    public List<Player> getActivePlayers() {
        return playerService.getActivePlayers();
    }

    /**
     * Ruft alle inaktiven Spieler ab.
     * @
     * @return  Eine neue Liste Player inaktiver Spieler werden angeigt die die Statusaktivität "inaktiv" haben
     */
    @GetMapping("/inactive")
    public List<Player> getInactivePlayers() {
        return playerService.getInActivePlayers();
    }

    /**
     * Erstellt einen neuen Spieler-Datensatz.
     * @param player Das Spieler-Objekt, das im Request-Body gesendet wird
     * @return der gespeicherte Player inklusiver generierter ID
     */
    @PostMapping("/add")
    public Player createPlayer(@RequestBody Player player) {
        // Tipp: In Postman muss hier ein JSON im Body sein!
        return playerService.addPlayer(player);
    }



    /**
     * Sucht Spieler basierend auf ihrer Nationalität.
     * @param nationality Die Nationalität als Pfad-Variable (z.B. /nationality/German).
     * @return Eine Liste von Spielern der entsprechenden Nationalität.
     */
    @GetMapping("/nationality/{nationality}")
    public List<Player> getPlayersByNationality(@PathVariable String nationality) {
        return playerService.findByNationality(nationality);
    }

    /**
     * Sucht Spieler basierend auf einem Statistik-Kriterium.
     * @param stats Das Statistik-Kriterium als Pfad-Variable.
     * @return Eine Liste von Spielern, die das Kriterium erfüllen.
     */
    @GetMapping("/stats/{stats}")
    public List<Player> getPlayersByStats(@PathVariable String stats) {
        return playerService.findByStats(stats);
    }

    /**
     * Ein vorhandener SPieler wird
     * @param id
     * @param playerDetails
     * @return
     */
    @PutMapping("/update/{id}")
    public Player updatePlayer(@PathVariable Integer id, @RequestBody Player playerDetails) {
        // Aktualisiert den Spieler mit der ID {id}
        return playerService.updatePlayer(id, playerDetails);
    }

    // --- DELETE: Eine Kategorie löschen ---
    // Hinweis: Normalerweise in einem CategoryController, hier als Beispiel:
    @DeleteMapping("/category/{id}")
    public String deleteCategory(@PathVariable Integer id) {
        // Hier rufen wir den Service auf, um die Kategorie zu entfernen
        playerService.deleteCategory(id);
        return "Kategorie " + id + " wurde erfolgreich gelöscht.";
    }
}

