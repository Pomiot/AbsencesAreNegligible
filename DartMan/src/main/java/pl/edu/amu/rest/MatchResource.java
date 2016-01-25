package pl.edu.amu.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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
import javax.ws.rs.core.Response;

import pl.edu.amu.database.MatchRepository;
import pl.edu.amu.repositoryImplementations.MatchRepositoryImpl;
import pl.edu.amu.rest.dto.Match;
import pl.edu.amu.rest.dto.Player;
import pl.edu.amu.rest.dto.ThrowSet;


@Path("/matches")
@Api(value = "matches", description = "Api for all match management needs")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MatchResource {

    private static MatchRepository matchRepository = new MatchRepositoryImpl();

    @GET
    @ApiOperation(value = "Gets list of all matches", response = Match.class, responseContainer = "List")
    public List<Match> getMatches() {
        return matchRepository.getAllMatches();
    }

    @POST
    @ApiOperation(value = "Creates new match", response = Match.class)
    public Response saveMatch(@ApiParam(value = "Match object to save.", required = true) Match match) {
        matchRepository.addMatch(match);
        return Response.status(201).entity(match).build();
    }

    @GET
    @Path("/{matchId}")
    @ApiOperation(value = "Gets match by given id", response = Match.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Match not found") })
    public Match getMatch(@ApiParam(value = "Id of match to fetch.", required = true) @PathParam("matchId") String matchId) {
        return matchRepository.getMatchById(Long.valueOf(matchId));
    }

    @DELETE
    @Path("/{matchId}")
    @ApiOperation(value = "Deletes match by given id")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Match not found") })
    public Response deleteMatch(@ApiParam(value = "Id of match to remove.", required = true) @PathParam("matchId") Long matchId) {
        matchRepository.deleteMatch(matchId);
        return Response.status(204).build();
    }

    @PUT
    @ApiOperation(value = "Modifies match with given id")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Match not found") })
    public Response modifyMatch(Match match) {
        matchRepository.updateMatch(match);
        return Response.status(200).entity(match).build();
    }

    @GET
    @Path("/{matchId}/players")
    @ApiOperation(value = "Gets players that take part in match with given id", response = Player.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Match not found") })
    public List<Player> getPlayersInMatch(@ApiParam(value = "Id of match to fetch players from.", required = true) @PathParam("matchId") Long matchId) {
        return matchRepository.getPlayersInMatch(matchId);
    }

    @GET
    @Path("/{matchId}/throws")
    @ApiOperation(value = "Gets all throws in match with given id", response = ThrowSet.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Match not found") })
    public List<ThrowSet> getThrowsInMatch(@ApiParam(value = "Id of match to fetch results from.", required = true)@PathParam("matchId") Long matchId){
        return matchRepository.getAllThrowsInMatch(matchId);
    }

    @GET
    @Path("/{matchId}/rounds/{roundNumber}")
    @ApiOperation(value = "Gets all throws in given round in match with given id", response = ThrowSet.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Match not found") })
    public List<ThrowSet> getThrowsInRound(@ApiParam(value = "Id of match to fetch results from.", required = true)@PathParam("matchId") Long matchId,
            @ApiParam(value = "Round number.", required = true) @PathParam("roundNumber") Integer roundNumber){
        return matchRepository.getThrowsInRound(matchId, roundNumber);
    }

    @POST
    @Path("/{matchId}/rounds/{roundNumber}")
    @ApiOperation(value = "Adds throw to given round in match with given id", response = ThrowSet.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Match not found"),
            @ApiResponse(code = 400, message = "Thrown when player with given login does not exist in database")})
    public Response addThrowSetToRound(@PathParam("matchId") Long matchId, @PathParam("roundNumber") Integer roundNumber, ThrowSet throwSet){
        matchRepository.addThrowSetToRound(matchId, roundNumber, throwSet);
        return Response.status(201).entity(throwSet).build();
    }
    
    @DELETE
    @Path("/{matchId}/throws/{throwId}")
    @ApiOperation(value = "Removes given throw if it belongs to match.")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Throw not found") })
    public Response deleteThrow(@PathParam("matchId") Long matchId, @PathParam("throwId") Long throwId) {
        matchRepository.deleteThrow(matchId, throwId);
        return Response.status(204).build();
    }
    
}
