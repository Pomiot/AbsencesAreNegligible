package pl.edu.amu.rest;

import io.swagger.annotations.Api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pl.edu.amu.database.TournamentRepository;
import pl.edu.amu.repositoryImplementations.TournamentRepositoryImpl;
import pl.edu.amu.rest.dto.Tournament;

@Path("/tournaments")
@Api(value = "/tournaments", description = "")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TournamentResource {

    private static TournamentRepository tournamentRepository = new TournamentRepositoryImpl();

    @GET
    public List<Tournament> getTournaments(){
        return tournamentRepository.getTournaments();
    }

    @POST
    public boolean saveTournament(Tournament tournament){
        return tournamentRepository.saveTournament(tournament);
    }

    @GET
    @Path("/{tournamentId}")
    public Tournament getTournament(@PathParam("tournamentId") final Long tournamentId){
        return tournamentRepository.getTournamentById(tournamentId);
    }

    @DELETE
    @Path("/{tournamentId}")
    public void deleteTournament(@PathParam("tournamentId") final Long tournamentId){
        tournamentRepository.deleteTournament(tournamentId);
    }

    @PUT
    public Tournament modifyTournament(Tournament tournament){
        return tournamentRepository.modifyTournament(tournament);
    }
}
