package pl.edu.amu.database;

import pl.edu.amu.rest.dto.Tournament;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pomiot on 24.01.2016.
 */
public class DummyTournamentRepository implements TournamentRepository {

    List<Tournament> tournaments = new ArrayList<>();

    @Override
    public List<Tournament> getTournaments() {
        return tournaments;
    }

    @Override
    public Tournament saveTournament(Tournament tournament) {
        tournaments.add(tournament);
        return tournament;
    }

    @Override
    public Tournament getTournamentById(String tournamentId) {
        return tournaments
                .stream()
                .filter(tournament -> tournamentId.equals(tournament.getId()))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public void deleteTournament(String tournamentId) {
        tournaments.remove(getTournamentById(tournamentId));
    }

    @Override
    public Tournament modifyTournament(String tournamentId, Tournament tournament) {
        deleteTournament(tournamentId);
        tournaments.add(tournament);
        return tournament;
    }
}
