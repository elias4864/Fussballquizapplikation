package org.example.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.model.Player;
import org.example.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PlayerService {


    /**     * Verknüpfung des Playie mit Repository bei  HTTP Datenüebrmittlugn zuerst an repostiryo udn dan weiter an Service der Daten verabreti udn COntroler ausführt

     * Dependency Injcetion zu Player Repository mit allen für den PlayerController  initialisierten  Methoden
     */
    private final PlayerRepository playerRepository;


    /** PlayerService Konsturktor mit playerrepostiory Referenzierung
     * @param playerRepository
     */

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    /**
     * Methode für CategoryCOntrolerl wird mit eirn SHleife erstlt die im Repostory überpfüt ob  mit der existsByID eine ID bereits existiert fall ja di evorderinierte deletbyId Methdo  welch anhan der Id eine Player löscht verwendet
     * @param id
     */
    public void deleteCategory(Integer id) {
        // Überprüfen, ob die Kategorie existiert, bevor man löscht
        if (playerRepository.existsById(id)) {
            playerRepository.deleteById(id);
        }
    }


    /**
     * Ein Spieler wirde aktualisiert und die Attribute FIrstName, LastName , BirthYear, Nationality. Stats, IsActive, Position werden  geändert und überprüft sowie in Repository gespeichert , Falls ein Spiler nicht  anhand der Id gefunden wrid eine neue ID erstellt
     * @param id
     * @param details
     * @return
     */

    public Player updatePlayer(Integer id, Player details) {
        return playerRepository.findById(id)
                .map(existingPlayer -> {
                    // Felder aktualisieren
                    existingPlayer.setFirstName(details.getFirstName());
                    existingPlayer.setLastName(details.getLastName());
                    existingPlayer.setBirthYear(details.getBirthYear());
                    existingPlayer.setNationality(details.getNationality());
                    existingPlayer.setStats(details.getStats());
                    existingPlayer.setIsactive(details.isIsactive());
                    existingPlayer.setPosition(details.getPosition());

                     if (details.getTeam() != null) {
                        existingPlayer.setTeam(details.getTeam());
                    }

                    return playerRepository.save(existingPlayer);
                })
                .orElseGet(() -> {
                    // Wenn nicht gefunden, unter der ID neu anlegen
                    details.setId(id);
                    return playerRepository.save(details);
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

    public List<Player> deletePlayer(String  firstName){
        return playerRepository.findByFirstName(firstName);
    }


}

