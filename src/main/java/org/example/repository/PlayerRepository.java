package org.example.repository;

import org.example.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player,Integer> {
    List<Player> findByIsactiveTrue();

    // alle inaktiven Spieler
    List<Player> findByIsactiveFalse();
    List<Player> findByNationality(String nationality);
    List<Player> findPlayer();


}
