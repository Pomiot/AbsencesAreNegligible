package pl.edu.amu.rest;

import io.swagger.annotations.Api;
import pl.edu.amu.database.MatchRepository;
import pl.edu.amu.rest.dto.Match;
import pl.edu.amu.rest.dto.Player;
import pl.edu.amu.rest.dto.ThrowSet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/matches")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MatchResource {

    MatchRepository matchRepository = null;


    @GET
    public List<Match> getMatches() {
        return matchRepository.getAllMatches();
    }

    @POST
    public Match saveMatch(Match match) {
        return matchRepository.addMatch(match);
    }

    @GET
    @Path("/{matchId}")
    public Match getMatch(@PathParam("matchId") String matchId) {
        return matchRepository.getMatchById(matchId);
    }

    @DELETE
    @Path("/{matchId}")
    public void deleteMatch(@PathParam("matchId") String matchId) {
        matchRepository.deleteMatch(matchId);
    }

    @PUT
    @Path("/{matchId}")
    public void modifyMatch(@PathParam("matchId") String matchId, Match match) {
        matchRepository.updateMatchById(matchId, match);
    }

    @GET
    @Path("/{matchId}/players")
    public List<Player> getPlayersInMatch(@PathParam("matchId") String matchId) {
        return matchRepository.getPlayersInMatch(matchId);
    }

    @GET
    @Path("/{matchId}/throws")
    public List<ThrowSet> getThrowsInMatch(@PathParam("matchId") String matchId){
        return matchRepository.getAllThrows(matchId);
    }

    @GET
    @Path("/{matchId}/round/{roundNumber}")
    public List<ThrowSet> getThrowsInRound(@PathParam("matchId") String matchId, @PathParam("roundNumber") Integer roundNumber){
        return matchRepository.getThrowsInRound(matchId, roundNumber);
    }

    @POST
    @Path("/{matchId}/round/{roundNumber}")
    public ThrowSet addThrowSetToRound(@PathParam("matchId") String matchId, @PathParam("roundNumber") Integer roundNumber, ThrowSet throwSet){
        return matchRepository.addThrowSetToRound(matchId, roundNumber, throwSet);
    }

}
