package pl.edu.amu.database;

import pl.edu.amu.rest.dto.Match;
import pl.edu.amu.rest.dto.Tournament;

import javax.ws.rs.NotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pomiot on 24.01.2016.
 */
public class DummyTournamentRepository implements TournamentRepository {

    static List<Tournament> tournaments = new ArrayList<>();

    @Override
    public List<Tournament> getTournaments() {
        return tournaments;
    }

    @Override
    public boolean saveTournament(Tournament tournament) {
        tournaments.add(tournament);
        return true;
    }

    @Override
    public Tournament getTournamentById(Long tournamentId) {
        return tournaments
                .stream()
                .filter(tournament -> tournamentId.equals(tournament.getId()))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public boolean deleteTournament(Long tournamentId) {
        tournaments.remove(getTournamentById(tournamentId));
        return true;
    }

    @Override
    public Tournament modifyTournament(Tournament tournament) {
        deleteTournament(tournament.getId());
        tournaments.add(tournament);
        return tournament;
    }

	@Override
	public List<Match> getTournamentMatches(Long tournamentId) {
		return null;
	}
}
