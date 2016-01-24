package pl.edu.amu.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import pl.edu.amu.database.DummyPlayerRepository;
import pl.edu.amu.database.PlayerRepository;
import pl.edu.amu.repositoryImplementations.PlayerRepositoryImpl;
import pl.edu.amu.rest.dto.Player;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Path("/players")
@Api("/players")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlayerResource {

    private static PlayerRepository playerRepository = new PlayerRepositoryImpl();

    @GET
    @ApiOperation(value = "Gets list of all players", response = Player.class)
    public List<Player> getPlayers(){

        return playerRepository.getAllPlayers();
    }

    @POST
    @ApiOperation(value = "Creates new player", response = Player.class)
    public Player savePlayer(@Valid Player player){

        playerRepository.addPlayer(player);
    	
        return player;
    }

    @GET
    @Path("/{login}")
    @ApiOperation(value = "Gets player by login", response = Player.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Player not found") })
    public Player getPlayer(@PathParam("login") final String login){
    	
    	return playerRepository.getPlayerByLogin(login);
   }

    @DELETE
    @Path("/{login}")
    @ApiOperation(value = "Removes player with given login")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Player not found") })
    public void deletePlayer(@PathParam("login") final String login) {

        playerRepository.deletePlayer(login);
    	
    }

    @PUT
    @ApiOperation(value = "modifies player with given login")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Player not found") })
    public Player modifyPlayer(@Valid Player player) {
        return playerRepository.updatePlayerByLogin(player);
    }

}
