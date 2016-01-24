package pl.edu.amu.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pl.edu.amu.rest.dto.Player;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adrian.perek on 2015-20-10.
 */
//@Singleton
@Path("/players")
@Api("players")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlayerResource {
    
    private static final List<Player> players = new ArrayList<>();

    @GET
    public List<Player> getPlayers(){
        return players;
    }

    @POST
    public Player savePlayer(@Valid Player player){
        players.add(player);
        return player;
    }

    @GET
    @Path("/{login}")
    @ApiOperation(value = "Gets player by login",
            response = Player.class)
    public Player getPlayer(@PathParam("login") final String login){
        return players
                .stream()
                .filter(user -> login.equals(user.getLogin()))
                .findFirst()
                .orElseThrow(NotFoundException::new);
   }

    @DELETE
    @Path("/{login}")
    public void deletePlayer(@PathParam("login") final String login) {

    }

    @PUT
    @Path("/{playerId}")
    public void modifyPlayer(@PathParam("login") final String login) {

    }

}
