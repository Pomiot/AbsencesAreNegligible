package pl.edu.amu.database;

import pl.edu.amu.rest.dto.ThrowSet;

import java.util.List;

public interface ThrowsRepository {

    List<ThrowSet> getThrowsByMatchId(Long matchId);

    ThrowSet getThrowSetById(String throwSetId);

    List<ThrowSet> getPlayerThrowsInMatch(Long matchId, String login);

    ThrowSet addThrowSet(ThrowSet throwSet);

    List<ThrowSet> getThrowsFromRoundInMatch(Long matchId, Integer roundNumber);

}
