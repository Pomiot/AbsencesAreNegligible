package pl.edu.amu.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pl.edu.amu.database.DummyMatchRepository;
import pl.edu.amu.database.MatchRepository;
import pl.edu.amu.rest.dto.Match;
import pl.edu.amu.rest.dto.Player;
import pl.edu.amu.rest.dto.ThrowSet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/matches")
@Api(value = "matches", description = "Api for all match management needs")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MatchResource {

    private static MatchRepository matchRepository = new DummyMatchRepository();

    @GET
    @ApiOperation(value = "Gets list of all matches", response = Match.class, responseContainer = "List")
    public List<Match> getMatches() {
        return matchRepository.getAllMatches();
    }

    @POST
    @ApiOperation(value = "Creates new match", response = Match.class)
    public Match saveMatch(Match match) {
        matchRepository.addMatch(match);

        return match;
    }

    @GET
    @Path("/{matchId}")
    @ApiOperation(value = "Gets match by given id", response = Match.class)
    public Match getMatch(@PathParam("matchId") String matchId) {
        return matchRepository.getMatchById(matchId);
    }

    @DELETE
    @Path("/{matchId}")
    @ApiOperation(value = "Deletes match by given id")
    public void deleteMatch(@PathParam("matchId") String matchId) {
        matchRepository.deleteMatch(matchId);
    }

    @PUT
    @Path("/{matchId}")
    @ApiOperation(value = "Modifies match with given id")
    public void modifyMatch(@PathParam("matchId") String matchId, Match match) {
        matchRepository.updateMatchById(matchId, match);
    }

    @GET
    @Path("/{matchId}/players")
    @ApiOperation(value = "Gets players that take part in match with given id", response = Player.class, responseContainer = "List")
    public List<Player> getPlayersInMatch(@PathParam("matchId") String matchId) {
        return matchRepository.getPlayersInMatch(matchId);
    }

    @GET
    @Path("/{matchId}/throws")
    @ApiOperation(value = "Gets all throws in match with given id", response = ThrowSet.class, responseContainer = "List")
    public List<ThrowSet> getThrowsInMatch(@PathParam("matchId") String matchId){
        return matchRepository.getAllThrowsInMatch(matchId);
    }

    @GET
    @Path("/{matchId}/round/{roundNumber}")
    @ApiOperation(value = "Gets all throws in given round in match with given id", response = ThrowSet.class, responseContainer = "List")
    public List<ThrowSet> getThrowsInRound(@PathParam("matchId") String matchId, @PathParam("roundNumber") Integer roundNumber){
        return matchRepository.getThrowsInRound(matchId, roundNumber);
    }

    @POST
    @Path("/{matchId}/round/{roundNumber}")
    @ApiOperation(value = "Adds throw to given round in match with given id", response = ThrowSet.class)
    public ThrowSet addThrowSetToRound(@PathParam("matchId") String matchId, @PathParam("roundNumber") Integer roundNumber, ThrowSet throwSet){
        return matchRepository.addThrowSetToRound(matchId, roundNumber, throwSet);
    }

}
