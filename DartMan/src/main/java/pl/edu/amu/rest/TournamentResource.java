package pl.edu.amu.rest;

import io.swagger.annotations.Api;
import pl.edu.amu.database.DummyTournamentRepository;
import pl.edu.amu.database.TournamentRepository;
import pl.edu.amu.rest.dto.Tournament;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/tournaments")
@Api(value = "/tournaments", description = "")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TournamentResource {

    private static TournamentRepository tournamentRepository = new DummyTournamentRepository();

    @GET
    public List<Tournament> getTournaments(){
        return tournamentRepository.getTournaments();
    }

    @POST
    public Tournament saveTournament(Tournament tournament){
        return tournamentRepository.saveTournament(tournament);
    }

    @GET
    @Path("/{tournamentId}")
    public Tournament getTournament(@PathParam("tournamentId") final String tournamentId){
        return tournamentRepository.getTournamentById(tournamentId);
    }

    @DELETE
    @Path("/{tournamentId}")
    public void deleteTournament(@PathParam("tournamentId") final String tournamentId){
        tournamentRepository.deleteTournament(tournamentId);
    }

    @PUT
    @Path("/{tournamentId}")
    public Tournament modifyTournament(@PathParam("tournamentId") final String tournamentId, Tournament tournament){
        return tournamentRepository.modifyTournament(tournamentId, tournament);
    }
}
