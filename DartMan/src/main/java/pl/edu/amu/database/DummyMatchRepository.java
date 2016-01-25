package pl.edu.amu.database;

import pl.edu.amu.rest.dto.Match;
import pl.edu.amu.rest.dto.Player;
import pl.edu.amu.rest.dto.ThrowSet;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Pomiot on 24.01.2016.
 */
public class DummyMatchRepository implements MatchRepository {

    static List<Match> matches = new ArrayList<>();

    ThrowsRepository throwsRepository = new DummyThrowsRepository();
    PlayerRepository playerRepository = new DummyPlayerRepository();

    @Override
    public List<Match> getAllMatches() {
        return matches;
    }

    @Override
    public Match getMatchById(Long matchId) throws NotFoundException {
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
    public boolean deleteMatch(Long matchId) {
        return matches.remove(getMatchById(matchId));
    }

    @Override
    public Match updateMatch(Match match) {
        deleteMatch(match.getId());
        matches.add(match);
        return match;
    }

    @Override
    public List<Player> getPlayersInMatch(Long matchId) {

        List<ThrowSet> throwSets = throwsRepository.getThrowsByMatchId(matchId);
        Set<Player> players = new TreeSet<>();
        for (ThrowSet throwSet : throwSets){
            players.add(playerRepository.getPlayerByLogin(throwSet.getPlayer()));
        }

        return new ArrayList<>(players);
    }

    @Override
    public List<ThrowSet> getAllThrowsInMatch(Long matchId) {
        return throwsRepository.getThrowsByMatchId(matchId);
    }

    @Override
    public List<ThrowSet> getThrowsInRound(Long matchId, Integer roundNumber) {
        return throwsRepository.getThrowsFromRoundInMatch(matchId, roundNumber);
    }

    @Override
    public ThrowSet addThrowSetToRound(Long matchId, Integer roundNumber, ThrowSet throwSet) {
        throwSet.setRound(roundNumber);
        throwSet.setMatchId(matchId);
        throwsRepository.addThrowSet(throwSet);
        return throwSet;
    }
}
