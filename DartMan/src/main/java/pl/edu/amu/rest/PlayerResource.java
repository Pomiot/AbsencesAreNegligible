package pl.edu.amu.rest;

import io.swagger.annotations.*;
import pl.edu.amu.database.PlayerRepository;
import pl.edu.amu.repositoryImplementations.PlayerRepositoryImpl;
import pl.edu.amu.rest.dto.Player;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

@Path("/players")
@Api("/players")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlayerResource {

    private static PlayerRepository playerRepository = new PlayerRepositoryImpl();

    @GET
    @ApiOperation(value = "Gets list of all players.", response = Player.class, responseContainer = "List")
    public List<Player> getPlayers(){

        return playerRepository.getAllPlayers();
    }

    @POST
    @ApiOperation(value = "Creates new player", response = Player.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Thrown when trying if player login or email is already in database.") })
    public Response savePlayer(@ApiParam(value = "Player object to add. Player login must be unique.", required = true) @Valid Player player){

        playerRepository.addPlayer(player);
    	
        return Response.status(201).entity(player).build();
    }

    @GET
    @Path("/{login}")
    @ApiOperation(value = "Gets player by login", response = Player.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Player not found") })
    public Player getPlayer(@ApiParam(value = "Login of player to fetch.", required = true) @PathParam("login") final String login){

    	return playerRepository.getPlayerByLogin(login);
   }

    @DELETE
    @Path("/{login}")
    @ApiOperation(value = "Removes player with given login")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Player not found") })
    public Response deletePlayer(@ApiParam(value = "Login of player to remove.", required = true) @PathParam("login") final String login) {

        playerRepository.deletePlayer(login);
        return Response.status(204).build();
    }

    @PUT
    @ApiOperation(value = "Modifies player with given login")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Player not found"),
            @ApiResponse(code = 400, message = "Thrown when trying if player email is already in database.")})
    public Response modifyPlayer(@ApiParam(value = "Updated player object. Player to update is choosen with player object login attribute.",
            required = true) @Valid Player player) {
        playerRepository.updatePlayer(player);
        return Response.status(200).entity(player).build();
    }

}
