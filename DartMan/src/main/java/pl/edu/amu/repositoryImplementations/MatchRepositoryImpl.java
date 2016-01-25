package pl.edu.amu.repositoryImplementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.NotFoundException;

import pl.edu.amu.database.DatabaseManager;
import pl.edu.amu.database.MatchRepository;
import pl.edu.amu.rest.dto.Match;
import pl.edu.amu.rest.dto.Player;
import pl.edu.amu.rest.dto.ThrowSet;

public class MatchRepositoryImpl implements MatchRepository {

	@Override
	public List<Match> getAllMatches() {
		
		EntityManager entityManager = DatabaseManager.getEntityManager();

		return entityManager.createQuery(
			    "SELECT m FROM Match m")
			    .getResultList();
	
	}

	@Override
	public Match getMatchById(Long matchId) throws NotFoundException {

		EntityManager entityManager = DatabaseManager.getEntityManager();

		try
		{
			return (Match) entityManager.createQuery(
					"SELECT m FROM Match m WHERE m.id = :matchId")
					.setParameter("matchId", matchId)
					.getSingleResult();
		}
		catch (Exception e)
		{
			throw new NotFoundException();
		}
	}

	@Override
	public boolean addMatch(Match match) {

		boolean result = false;

		EntityManager entityManager = DatabaseManager.getEntityManager();
		try
		{
			entityManager.getTransaction().begin();
			entityManager.persist(match);
			entityManager.getTransaction().commit();

			result = true;
		}
		catch (Exception e)
		{
			entityManager.getTransaction().rollback();

			result = false;
		}

		return result;
	}

	@Override
	public boolean deleteMatch(Long matchId) {
		
		EntityManager entityManager = DatabaseManager.getEntityManager();

		try
		{
			entityManager.getTransaction().begin();
			entityManager.remove(getMatchById(matchId));
			entityManager.getTransaction().commit();
			
			return true;
		}
		catch (Exception e)
		{	
			entityManager.getTransaction().rollback();
			
			throw new NotFoundException();
		}
	}

	@Override
	public Match updateMatch(Match match) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> getPlayersInMatch(Long matchId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ThrowSet> getAllThrowsInMatch(Long matchId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ThrowSet> getThrowsInRound(Long matchId, Integer roundNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ThrowSet addThrowSetToRound(Long matchId, Integer roundNumber,
			ThrowSet throwSet) {
		// TODO Auto-generated method stub
		return null;
	}


}
