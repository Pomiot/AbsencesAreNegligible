package pl.edu.amu.database;

import pl.edu.amu.rest.dto.Match;
import pl.edu.amu.rest.dto.Player;
import pl.edu.amu.rest.dto.ThrowSet;

import javax.ws.rs.NotFoundException;
import java.util.List;

public interface MatchRepository {

    List<Match> getAllMatches();

    Match getMatchById(Long matchId) throws NotFoundException;

    boolean addMatch(Match match);

    boolean deleteMatch(Long matchId);

    Match updateMatch(Match match);

    List<Player> getPlayersInMatch(Long matchId);

    List<ThrowSet> getAllThrowsInMatch(Long matchId);

    List<ThrowSet> getThrowsInRound(Long matchId, Integer roundNumber);

    ThrowSet addThrowSetToRound(Long matchId, Integer roundNumber, ThrowSet throwSet);

}
