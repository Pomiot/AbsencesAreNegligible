package pl.edu.amu.database;

import pl.edu.amu.rest.dto.Player;

import javax.ws.rs.NotFoundException;
import java.util.List;

/**
 * Created by Pomiot on 24.01.2016.
 */
public interface PlayerRepository {
    List getAllPlayers();

    Player getPlayerByLogin(String login) throws NotFoundException;

    boolean addPlayer(Player player);

    boolean deletePlayer(String login);

    Player updatePlayerByLogin(Player player);
}
