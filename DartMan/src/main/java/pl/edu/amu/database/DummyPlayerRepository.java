package pl.edu.amu.database;

import pl.edu.amu.rest.dto.Player;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pomiot on 24.01.2016.
 */
public class DummyPlayerRepository implements PlayerRepository {

    static List<Player> players = new ArrayList<>();

    @Override
    public List<Player> getAllPlayers() {
        return players;
    }

    @Override
    public Player getPlayerByLogin(String login) throws NotFoundException {

        return players
                .stream()
                .filter(user -> login.equals(user.getLogin()))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public boolean addPlayer(Player player) {
        return players.add(player);
    }

    @Override
    public boolean deletePlayer(String login) {
        return players.remove(getPlayerByLogin(login));
    }

    @Override
    public Player updatePlayer(Player player) {

        deletePlayer(player.getLogin());
        boolean result = addPlayer(player);
        if(result) return player;
        else return null;
    }
}
