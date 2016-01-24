package pl.edu.amu.database;

import pl.edu.amu.rest.dto.ThrowSet;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Pomiot on 24.01.2016.
 */
public class DummyThrowsRepository implements ThrowsRepository {

    static List<ThrowSet> throwSets = new ArrayList<>();

    @Override
    public List<ThrowSet> getThrowsByMatchId(String matchId) {

        List<ThrowSet> throwSetsInMatch = throwSets.stream().filter(throwSet -> throwSet.getMatchId().equals(matchId)).collect(Collectors.toList());

        return throwSetsInMatch;
    }

    @Override
    public ThrowSet getThrowSetById(String throwSetId) {
        return throwSets
                .stream()
                .filter(throwSet -> throwSetId.equals(throwSet.getId()))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<ThrowSet> getPlayerThrowsInMatch(String matchId, String login) {

        List<ThrowSet> throwSetsInMatch = throwSets.stream().filter(throwSet -> throwSet.getMatchId().equals(matchId) && throwSet.getPlayer().equals(login)).collect(Collectors.toList());
        return throwSetsInMatch;
    }

    @Override
    public ThrowSet addThrowSet(ThrowSet throwSet) {
        throwSets.add(throwSet);
        return throwSet;

    }

    @Override
    public List<ThrowSet> getThrowsFromRoundInMatch(String matchId, Integer roundNumber) {
        List<ThrowSet> throwSetsInMatch = throwSets.stream().filter(throwSet -> throwSet.getMatchId().equals(matchId) && throwSet.getRound().equals(roundNumber)).collect(Collectors.toList());
        return throwSetsInMatch;
    }
}
