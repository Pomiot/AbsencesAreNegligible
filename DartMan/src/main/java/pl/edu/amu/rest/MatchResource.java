package pl.edu.amu.rest;

import io.swagger.annotations.Api;
import pl.edu.amu.rest.dto.Match;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


@Path("/matches")
@Api("matches")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MatchResource {

    private static final List<Match> matches = new ArrayList<>();

    @GET
    public List<Match> getMatches() {
        return null;
    }

    @POST
    public Match saveMatch(Match match) {
        return null;
    }

    @GET
    @Path("/{matchId}")
    public Match getMatch(@PathParam("matchId") String matchId) {
        return null;
    }

    @DELETE
    @Path("/{matchId}")
    public void deleteMatch(@PathParam("matchId") String matchId) {

    }

    @PUT
    @Path("/{matchId}")
    public void modifyMatch(@PathParam("matchId") String matchId) {

    }
}
