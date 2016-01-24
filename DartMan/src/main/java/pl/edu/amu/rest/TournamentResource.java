package pl.edu.amu.rest;

import io.swagger.annotations.Api;
import pl.edu.amu.rest.dto.Tournament;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/tournaments")
@Api("tournaments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TournamentResource {

    @GET
    public List<Tournament> getTournaments(){
        return null;
    }

    @POST
    public Tournament saveTournament(Tournament tournament){
        return null;
    }

    @GET
    @Path("/{tournamentId}")
    public Tournament getTournament(@PathParam("tournamentId") final String tournamentId){
        return null;
    }

    @DELETE
    @Path("/{tournamentId}")
    public void deleteTournament(@PathParam("tournamentId") final String tournamentId){

    }

    @PUT
    @Path("/{tournamentId}")
    public void modifyTournament(@PathParam("tournamentId") final String tournamentId){

    }
}
