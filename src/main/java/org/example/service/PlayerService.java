package org.example.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.model.Player;
import org.example.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Player service.
 */
@Service

public class PlayerService {


    /**     * Verknüpfung des Playie mit Repository bei  HTTP Datenüebrmittlugn zuerst an repostiryo udn dan weiter an Service der Daten verabreti udn COntroler ausführt

     * Dependency Injcetion zu Player Repository mit allen für den PlayerController  initialisierten  Methoden
     */
    private final PlayerRepository playerRepository;


    /**
     * PlayerService Konsturktor mit playerrepostiory Referenzierung
     *
     * @param playerRepository the player repository
     */
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    /**
     * Methode für CategoryCOntrolerl wird mit eirn SHleife erstlt die im Repostory überpfüt ob  mit der existsByID eine ID bereits existiert fall ja di evorderinierte deletbyId Methdo  welch anhan der Id eine Player löscht verwendet
     *
     * @param id the id
     */
    public void deleteCategory(Integer id) {
        // Überprüfen, ob die Kategorie existiert, bevor man löscht
        if (playerRepository.existsById(id)) {
            playerRepository.deleteById(id);
        }
    }


    /**
     * Ein Spieler wirde aktualisiert und die Attribute FIrstName, LastName , BirthYear, Nationality. Stats, IsActive, Position werden  geändert und überprüft sowie in Repository gespeichert , Falls ein Spiler nicht  anhand der Id gefunden wrid eine neue ID erstellt
     *

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    /**
     * Add player player.
     *
     * @param player the player
     * @return the player
     */
    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    /**
     * Find by stats list.
     *
     * @param stats the stats
     * @return the list
     */
    public List<Player> findByStats(String stats){
        return playerRepository.findByStats(stats);
    }

    /**
     * Find by nationality list.
     *
     * @param nationality the nationality
     * @return the list
     */
    public List<Player> findByNationality(String nationality) {
        return playerRepository.findByNationality(nationality);
    }

    /**
     * Gets player.
     *
     * @param id the id
     * @return the player
     */
    public Player getPlayer(int id) {
        return playerRepository.findById(id)
                .orElse(null); // oder throw new RuntimeException("...");
    }


    /**
     * Update player player.
     *
     * @param id            the id
     * @param playerDetails the player details
     * @return the player
     */
    public Player updatePlayer(Integer id, Player playerDetails) {
        // 1. Spieler suchen oder Fehler werfen
        Player existingPlayer = playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Spieler nicht gefunden mit ID: " + id));

        // 2. Felder aktualisieren (Beispiele)
        existingPlayer.setFirstName(playerDetails.getFirstName());
        if (playerDetails.getTeam() != null) {
            existingPlayer.setTeam(playerDetails.getTeam());
        }
        // ... weitere Felder hier anpassen

        // 3. Speichern und zurückgeben
        return playerRepository.save(existingPlayer);
    }

    /**
     * Gets active players.
     *
     * @return the active players
     */
    public List<Player> getActivePlayers() {
        return playerRepository.findByisactive(true);
    }


    /**
     * Gets in active players.
     *
     * @return the in active players
     */
    public List<Player> getInActivePlayers() {
        return playerRepository.findByisactive(false);
    }

    /**
     * Delete player list.
     *
     * @param firstName the first name
     * @return the list
     */
    public List<Player> deletePlayer(String  firstName){
        return playerRepository.findByFirstName(firstName);
    }


}

