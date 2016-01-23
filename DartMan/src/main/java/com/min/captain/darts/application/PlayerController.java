package com.min.captain.darts.application;

import org.hibernate.Session;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.min.captain.darts.application.player.Player;
import com.min.captain.darts.utils.HibernateUtils;

@RestController
@RequestMapping(value="/players")
public class PlayerController 
{
	private Session session;
	
	@RequestMapping(method = RequestMethod.POST)
	public Player createPlayer(@RequestParam(value="first") String firstName, 
    		@RequestParam(value="last") String lastName){
        Player player = new Player(firstName, lastName);
        
        session = HibernateUtils.createAndOpenSession();
        HibernateUtils.saveToDb(session, player);
        HibernateUtils.commit(session);
        HibernateUtils.close(session);
        return player;
    }
	
	@RequestMapping(method = RequestMethod.GET)
	public void getPlayers(){
		System.out.println("getPlayers method.");
	}

	@RequestMapping(value = "/{playerId}", method = RequestMethod.GET)
	public void getPlayerByID(@PathVariable String playerId){
		System.out.println("getPlayerByID method - id: " + playerId);
	}

	@RequestMapping(value = "/{playerId}", method = RequestMethod.PUT)
	public void modifyPlayer(@PathVariable String playerId){
		System.out.println("modifyPlayer method - id: " + playerId);
	}

	@RequestMapping(value = "/{playerId}", method = RequestMethod.DELETE)
	public void deletePlayer(@PathVariable String playerId){
		System.out.println("deletePlayer method - id: " + playerId);
	}


}
