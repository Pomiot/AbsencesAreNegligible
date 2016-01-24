package pl.edu.amu.database;

import pl.edu.amu.rest.dto.Match;
import pl.edu.amu.rest.dto.Player;
import pl.edu.amu.rest.dto.ThrowSet;

import javax.ws.rs.NotFoundException;
import java.util.List;

public interface MatchRepository {

    List<Match> getAllMatches();

    Match getMatchById(String matchId) throws NotFoundException;

    boolean addMatch(Match match);

    boolean deleteMatch(String matchId);

    Match updateMatchById(String matchId, Match match);

    List<Player> getPlayersInMatch(String matchId);

    List<ThrowSet> getAllThrowsInMatch(String matchId);

    List<ThrowSet> getThrowsInRound(String matchId, Integer roundNumber);

    ThrowSet addThrowSetToRound(String matchId, Integer roundNumber, ThrowSet throwSet);

}
