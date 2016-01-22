package com.min.captain.darts.application;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.min.captain.darts.application.player.Player;
import com.min.captain.darts.utils.HibernateUtils;

@RestController
@RequestMapping(value="/player")
public class PlayerController 
{
	@RequestMapping(value="/test")
	public Player createPlayer(@RequestParam(value="first") String firstName, 
    		@RequestParam(value="last") String lastName) 
	{
        Player player = new Player(firstName, lastName);
        
        HibernateUtils.saveToDb(player);
        
        return player;
    }
	
	@RequestMapping(method = RequestMethod.GET)
	public void printSomething()
	{
		System.out.println("test");
	}
}
