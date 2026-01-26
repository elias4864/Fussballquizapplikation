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




public class PlayerValidatorTest
{


    /**
     * The Player repo.
     */
    @Mock PlayerRepository playerRepo;
    /**
     * The Team repo.
     */
    @Mock TeamRepository teamRepo;
    /**
     * The League repo.
     */
    @Mock LeagueRepository leagueRepo;

    /**
     * The Validator.
     */
    @InjectMocks PlayerValidierung validator;

    /**
     * Test valid player.
     */
    @Test
    void testValidPlayer() {

        Player p = new Player();
        p.setId(1);

        Player p1 = new Player();
        p.setId(10);

        Team t = new Team();
        t.setId(100);

        League l = new League();
        l.setId("CL");

        p.setTeam(t);
        t.setLeague(l);


        when(playerRepo.findById(1)).thenReturn(Optional.of(p));
        when(playerRepo.findById(10)).thenReturn(Optional.of(p));

        assertDoesNotThrow(() -> validator.validatePlayer(1));
        assertDoesNotThrow(()->validator.validatePlayer(10));
    }

    /**
     * Test player not found.
     */
    @Test
    void testPlayerNotFound() {
        when(playerRepo.findById(10)).thenReturn(Optional.empty());
        assertThrows(ValidationException.class, () -> validator.validatePlayer(10));
    }

    /**
     * Test team not found.
     */
    @Test
    void testTeamNotFound() {
        Player p = new Player();
        p.setId(1);
        Player p1 = new Player();
        p1.setId(10);

        Team missingTeam = new Team();
        missingTeam.setId(999);
        p.setTeam(missingTeam);
        p1.setTeam(missingTeam);

        when(playerRepo.findById(1)).thenReturn(Optional.of(p));
        when(playerRepo.findById(10)).thenReturn(Optional.of(p1));
        when(teamRepo.findById(999)).thenReturn(Optional.empty());

        assertThrows(ValidationException.class, () -> validator.validatePlayer(1));
        assertThrows(ValidationException.class, ()->validator.validatePlayer(10));

    }

    /**
     * Test league not found.
     */
    @Test
    void testLeagueNotFound() {
        Player p = new Player();
        p.setId(1);

        Player p1 = new Player();
        p1.setId(10);

        Team t = new Team();
        t.setId(100);
        League missing = new League();
        missing.setId("XX");

        t.setLeague(missing);
        p.setTeam(t);
        p1.setTeam(t);

        when(playerRepo.findById(1)).thenReturn(Optional.of(p));
        when(teamRepo.findById(100)).thenReturn(Optional.of(t));
        when(playerRepo.findById(10)).thenReturn(Optional.of(p1));
        when(leagueRepo.findById("XX")).thenReturn(Optional.empty());

        assertThrows(ValidationException.class, () -> validator.validatePlayer(1));
        assertThrows(ValidationException.class,()-> validator.validatePlayer(10));
    }

}
