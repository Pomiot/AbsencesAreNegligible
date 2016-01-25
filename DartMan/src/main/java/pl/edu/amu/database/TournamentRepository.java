package pl.edu.amu.database;

import pl.edu.amu.rest.dto.Tournament;

import java.util.List;

/**
 * Created by Pomiot on 24.01.2016.
 */
public interface TournamentRepository {

    List<Tournament> getTournaments();

    boolean saveTournament(Tournament tournament);

    Tournament getTournamentById(Long tournamentId);

    boolean deleteTournament(Long tournamentId);

    Tournament modifyTournament(Tournament tournament);

}
