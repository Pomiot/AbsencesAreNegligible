package pl.edu.amu.database;

import pl.edu.amu.rest.dto.Tournament;

import java.util.List;

/**
 * Created by Pomiot on 24.01.2016.
 */
public interface TournamentRepository {

    List<Tournament> getTournaments();

    Tournament saveTournament(Tournament tournament);

    Tournament getTournamentById(String tournamentId);

    void deleteTournament(String tournamentId);

    Tournament modifyTournament(String tournamentId, Tournament tournament);

}
