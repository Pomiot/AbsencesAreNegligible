package pl.edu.amu.database;

import pl.edu.amu.rest.dto.Match;
import pl.edu.amu.rest.dto.Player;
import pl.edu.amu.rest.dto.ThrowSet;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pomiot on 24.01.2016.
 */
public class DummyMatchRepository implements MatchRepository {

    List<Match> matches = new ArrayList<>();

    @Override
    public List<Match> getAllMatches() {
        return matches;
    }

    @Override
    public Match getMatchById(String matchId) throws NotFoundException {
        return matches
                .stream()
                .filter(match -> matchId.equals(match.getId()))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public boolean addMatch(Match match) {
        return matches.add(match);
    }

    @Override
    public boolean deleteMatch(String matchId) {
        return matches.remove(getMatchById(matchId));
    }

    @Override
    public Match updateMatchById(String matchId, Match match) {
        deleteMatch(matchId);
        matches.add(match);
        return match;
    }

    @Override
    public List<Player> getPlayersInMatch(String matchId) {

        List<Player> players = new ArrayList<>();

        Match match = getMatchById(matchId);
        for(ThrowSet throwSet : match.getThrowSets()){
            players.add(throwSet.getPlayer());
        }

        return players;
    }

    @Override
    public List<ThrowSet> getAllThrows(String matchId) {
        Match match = getMatchById(matchId);

        return new ArrayList<>(match.getThrowSets());
    }

    @Override
    public List<ThrowSet> getThrowsInRound(String matchId, Integer roundNumber) {
        return null;
    }

    @Override
    public ThrowSet addThrowSetToRound(String matchId, Integer roundNumber, ThrowSet throwSet) {
        Match match = getMatchById(matchId);
        throwSet.setRound(roundNumber);
        match.getThrowSets().add(throwSet);
        return throwSet;
    }
}
