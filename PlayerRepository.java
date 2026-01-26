package org.example.repository;

import org.example.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * JPA Dependency Player repository erbt vom JPA Repository  für Datenbankzugriff  zu Player Liste zu Entität Player durch Constraint mit  dem Primary Key Integer
 */
public interface PlayerRepository extends JpaRepository<Player,Integer> {

    /**
     * Alle SPieler mit  von JPA vorderfinierten Methode findByStats anhand des Atributs stats die Torbilanz eine SPielers anzeigt  mit dem
     *
     * @param stats the stats
     * @return List Player mit bestimmter Torbilanz
     */
    List<Player> findByStats(String stats);

    /**
     * Alle Aktiven  Datnsätze der  Spieler Liste  werden durch das Attribut isactive  üebr ihre SPieleraktivität geprüft  werden und eien neue Liste  welche im Parameter boolean true steht
     *
     * @param isactive the isactive
     * @return List Player mit bestimmter Nationalität
     */
    List<Player> findByisactive(boolean isactive);

    /**
     * Ein bestimmter Spieler wird anhan des  Vornamens abefragt
     *
     * @param firstName the first name
     * @return List Player
     */
    List<Player> findByFirstName(String firstName);


    /**
     * Alle SPieler Datensätze anhand des Attributs mit einer bestimmten  Nationalität  werden  mit einem bestimmten Attribut nationality   ausgegeben werden
     *
     * @param nationality the nationality
     * @return Lislt PLayer
     */
    List<Player> findByNationality(String nationality);

}
