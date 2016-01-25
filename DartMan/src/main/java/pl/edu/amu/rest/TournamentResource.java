package pl.edu.amu.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import pl.edu.amu.database.TournamentRepository;
import pl.edu.amu.repositoryImplementations.TournamentRepositoryImpl;
import pl.edu.amu.rest.dto.Match;
import pl.edu.amu.rest.dto.Tournament;

@Path("/tournaments")
@Api(value = "/tournaments", description = "")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TournamentResource {

    private static TournamentRepository tournamentRepository = new TournamentRepositoryImpl();

    @GET
    @ApiOperation(value = "Gets list of all tournaments", response = Tournament.class, responseContainer = "List")
    public List<Tournament> getTournaments(){
        return tournamentRepository.getTournaments();
    }

    @POST
    @ApiOperation(value = "Creates new tournament", response = Tournament.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Thrown when tournament name already exists in database") })
    public Response saveTournament(@Valid Tournament tournament){
        tournamentRepository.saveTournament(tournament);

        return Response.status(201).entity(tournament).build();
    }

    @GET
    @Path("/{tournamentId}")
    @ApiOperation(value = "Gets tournament by Id", response = Tournament.class)
    public Tournament getTournament(@PathParam("tournamentId") final Long tournamentId){
        return tournamentRepository.getTournamentById(tournamentId);
    }

    @DELETE
    @Path("/{tournamentId}")
    @ApiOperation(value = "Removes tournament with given Id", response = Tournament.class)
    public Response deleteTournament(@PathParam("tournamentId") final Long tournamentId){
        tournamentRepository.deleteTournament(tournamentId);
        return Response.status(204).build();
    }

    @PUT
    @ApiOperation(value = "Modifies tournament with given Id", response = Tournament.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Thrown when tournament name already exists in database") })
    public Response modifyTournament(@Valid Tournament tournament){
        tournamentRepository.modifyTournament(tournament);
        return Response.status(200).entity(tournament).build();
    }
    
    @GET
    @Path("/{tournamentId}/matches")
    @ApiOperation(value = "Gets matches that belong to tournament with given Id", response = Match.class, responseContainer = "List")
    public List<Match> getTournamentMatches(@PathParam("tournamentId") final Long tournamentId){
        return tournamentRepository.getTournamentMatches(tournamentId);
    }
}
