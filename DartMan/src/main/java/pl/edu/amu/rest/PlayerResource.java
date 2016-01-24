package pl.edu.amu.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import pl.edu.amu.database.PlayerUtility;
import pl.edu.amu.rest.dto.Player;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/players")
@Api("players")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlayerResource {
    
    private static final List<Player> players = new ArrayList<>();

    @GET
    @ApiOperation(value = "Gets list of all players", response = Player.class)
    public List<Player> getPlayers(){
    	
        return PlayerUtility.getAllPlayers();
    }

    @POST
    @ApiOperation(value = "Creates new player", response = Player.class)
    public Player savePlayer(@Valid Player player){
        
    	PlayerUtility.addPlayer(player);
    	
        return player;
    }

    @GET
    @Path("/{login}")
    @ApiOperation(value = "Gets player by login", response = Player.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Player not found") })
    public Player getPlayer(@PathParam("login") final String login){
    	
    	return PlayerUtility.getPlayerByLogin(login);
    	
    	//        return players
//                .stream()
//                .filter(user -> login.equals(user.getLogin()))
//                .findFirst()
//                .orElseThrow(NotFoundException::new);
   }

    @DELETE
    @Path("/{login}")
    @ApiOperation(value = "Removes player with given login")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Player not found") })
    public void deletePlayer(@PathParam("login") final String login) {
    	
    	PlayerUtility.deletePlayer(login);
    	
    }

    @PUT
    @Path("/{login}")
    @ApiOperation(value = "modifies player with given login")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Player not found") })
    public Player modifyPlayer(@PathParam("login") final String login, @Valid Player player) {
        return null;
    }

}
