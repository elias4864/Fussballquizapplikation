package wiss.m295;

import jakarta.validation.ValidationException;
import org.example.PlayerValidierung;
import org.example.model.League;
import org.example.model.Player;
import org.example.model.Team;
import org.example.repository.LeagueRepository;
import org.example.repository.PlayerRepository;
import org.example.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


/**
 * The type Player validator test.
 */
@ExtendWith(MockitoExtension.class)




public class PlayerValidatorTest {

@Mock PlayerRepository playerRepo;
@Mock TeamRepository teamRepo;
@Mock LeagueRepository leagueRepo;

@InjectMocks PlayerValidierung validator;

@Test
void testValidPlayer_ShouldPass() {
    // Arrange
    int playerId = 1;

    int teamId = 100;
    String leagueId = "CL";


    int id = 20;



    League league = new League(); league.setId(leagueId);
    Team team = new Team(); team.setId(teamId); team.setLeague(league);
    Player player = new Player(); player.setId(playerId); player.setTeam(team);

    when(playerRepo.findById(playerId)).thenReturn(Optional.of(player));
    when(teamRepo.findById(teamId)).thenReturn(Optional.of(team));
    when(leagueRepo.findById(leagueId)).thenReturn(Optional.of(league));

    // Act & Assert
    assertDoesNotThrow(() -> validator.validatePlayer(playerId));
    assertDoesNotThrow(()->validator.validatePlayer(playerId));
}

@Test
void testTeamNotFound_ShouldThrow() {
    // Arrange
    int playerId = 1;
    int teamId = 999;

    Team team = new Team(); team.setId(teamId);
    Player player = new Player(); player.setId(playerId); player.setTeam(team);

    when(playerRepo.findById(playerId)).thenReturn(Optional.of(player));
    // WICHTIG: Explizit sagen, dass das Team fehlt
    when(teamRepo.findById(teamId)).thenReturn(Optional.empty());

    // Act & Assert
    assertThrows(ValidationException.class, () -> validator.validatePlayer(playerId));
    assertThrows(ValidationException.class, ()->validator.validatePlayer(playerId));
}

}
