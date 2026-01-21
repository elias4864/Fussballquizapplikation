package org.example;

import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.example.model.Player;
import org.example.model.Question;
import org.example.model.Team;
import org.example.model.League;
import org.example.repository.PlayerRepository;
import org.example.repository.QuestionRepository;
import org.example.repository.TeamRepository;
import org.example.repository.LeagueRepository;
import org.springframework.stereotype.Component;
@Component
public class PlayerValidierung {


    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final LeagueRepository leagueRepository;

    public PlayerValidierung(PlayerRepository playerRepository,
                             TeamRepository teamRepository,
                             LeagueRepository leagueRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
        this.leagueRepository = leagueRepository;
    }

    public void validatePlayer(int playerId) {

        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new ValidationException("❌ Spieler existiert nicht: " + playerId));

        if (player.getTeam() != null) {
            teamRepository.findById(player.getTeam().getId())
                    .orElseThrow(() -> new ValidationException("❌ Team existiert nicht!"));
        }

        if (player.getTeam() != null && player.getTeam().getLeague() != null) {
            leagueRepository.findById(player.getTeam().getLeague().getId())
                    .orElseThrow(() -> new ValidationException("❌ Liga existiert nicht!"));
        }

        System.out.println("✔ Spieler erfolgreich validiert: " + playerId);
    }

}
