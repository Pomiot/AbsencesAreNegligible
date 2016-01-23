package com.min.captain.darts.application;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/matches")
public class MatchController {

    @RequestMapping(method = RequestMethod.GET)
    public void getMatches(){
        System.out.println("getMatches method.");
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createMatch(){
        System.out.println("createMatch method.");
    }

    @RequestMapping(value = "/{matchId}", method = RequestMethod.GET)
    public void getMatchByID(@PathVariable String matchId){
        System.out.println("getMatchByID method - id: " + matchId);
    }

    @RequestMapping(value = "/{matchId}", method = RequestMethod.PUT)
    public void modifyMatch(@PathVariable String matchId){
        System.out.println("modifyMatch method - id: " + matchId);
    }

    @RequestMapping(value = "/{matchId}", method = RequestMethod.DELETE)
    public void deleteMatch(@PathVariable String matchId){
        System.out.println("deleteMatch method - id: " + matchId);
    }

    @RequestMapping(value = "/{matchId}/players/", method = RequestMethod.GET)
    public void getPlayersInMatch(@PathVariable String matchId){
        System.out.println("getPlayersInMatch method - id: " + matchId);
    }

    @RequestMapping(value = "/{matchId}/players/{playerId}", method = RequestMethod.GET)
    public void getPlayerResultsInMatch(@PathVariable String matchId, @PathVariable String playerId){
        System.out.println("getPlayersInMatch method - id: " + matchId);
    }

    @RequestMapping(value = "/{matchId}/rounds", method = RequestMethod.GET)
    public void getRoundsInMatch(@PathVariable String matchId){
        System.out.println("getRoundsInMatch method - id: " + matchId);
    }

    @RequestMapping(value = "/{matchId}/rounds/{roundNumber}", method = RequestMethod.GET)
    public void getSpecificRoundInMatch(@PathVariable String matchId, @PathVariable String roundNumber){
        System.out.println("getSpecificRoundInMatch - match id: " + matchId + ", roundNumber: " + roundNumber);
    }

    @RequestMapping(value = "/{matchId}/rounds/{roundNumber}", method = RequestMethod.PUT)
    public void modifySpecificRoundInMatch(@PathVariable String matchId, @PathVariable String roundNumber){
        System.out.println("modifySpecificRoundInMatch - match id: " + matchId + ", roundNumber: " + roundNumber);
    }

    @RequestMapping(value = "/{matchId}/rounds/{roundNumber}", method = RequestMethod.POST)
    public void addThrowSetToSpecificRoundInMatch(@PathVariable String matchId, @PathVariable String roundNumber){
        System.out.println("addThrowSetToSpecificRoundInMatch - match id: " + matchId + ", roundNumber: " + roundNumber);
    }

    @RequestMapping(value = "/{matchId}/rounds/{roundNumber}", method = RequestMethod.DELETE)
    public void clearSpecificRoundInMatch(@PathVariable String matchId, @PathVariable String roundNumber){
        System.out.println("clearSpecificRoundInMatch - match id: " + matchId + ", roundNumber: " + roundNumber);
    }

}
