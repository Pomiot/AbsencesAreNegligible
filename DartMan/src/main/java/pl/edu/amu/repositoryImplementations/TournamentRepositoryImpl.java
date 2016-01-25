package pl.edu.amu.repositoryImplementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.NotFoundException;

import pl.edu.amu.database.DatabaseManager;
import pl.edu.amu.database.TournamentRepository;
import pl.edu.amu.rest.dto.Match;
import pl.edu.amu.rest.dto.Tournament;

public class TournamentRepositoryImpl implements TournamentRepository {

	@Override
	public List<Tournament> getTournaments() {
		
		EntityManager entityManager = DatabaseManager.getEntityManager();

		return entityManager.createQuery(
			    "SELECT t FROM Tournament t")
			    .getResultList();
	}

	@Override
	public boolean saveTournament(Tournament tournament) {
		
		boolean result = false;

		EntityManager entityManager = DatabaseManager.getEntityManager();
		try
		{
			entityManager.getTransaction().begin();
			entityManager.persist(tournament);
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
	public Tournament getTournamentById(Long tournamentId) {
		
		EntityManager entityManager = DatabaseManager.getEntityManager();

		try
		{
			return (Tournament) entityManager.createQuery(
					"SELECT t FROM Tournament t WHERE t.id = :tournamentId")
					.setParameter("tournamentId", tournamentId)
					.getSingleResult();
		}
		catch (Exception e)
		{
			throw new NotFoundException();
		}
	}

	@Override
	public boolean deleteTournament(Long tournamentId) {
		
		EntityManager entityManager = DatabaseManager.getEntityManager();

		try
		{
			entityManager.getTransaction().begin();
			entityManager.remove(getTournamentById(tournamentId));
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
	public Tournament modifyTournament(Tournament tournament) {

		EntityManager entityManager = DatabaseManager.getEntityManager();
		
		try
		{
			String actualTournamentName = null;
			try
			{
				actualTournamentName = (String) entityManager.createQuery(
						"SELECT t.tournamentName FROM Tournament t WHERE t.id = :id")
						.setParameter("id", tournament.getId())
						.getSingleResult();
			}
			catch (Exception e)
			{
				throw new NotFoundException();
			}
			
			entityManager.getTransaction().begin();
			
			if (actualTournamentName != null)
			{
				entityManager.createQuery(
						"UPDATE Match m SET m.tournamentName = :newName WHERE m.tournamentName LIKE :actualName")
						.setParameter("newName", tournament.getTournamentName())
						.setParameter("actualName", actualTournamentName)
						.executeUpdate();
			}
			
			entityManager.createQuery(
					"UPDATE Tournament t SET t.tournamentName = :newName WHERE t.id = :id")
					.setParameter("id", tournament.getId())
					.setParameter("newName", tournament.getTournamentName())
					.executeUpdate();
			
			entityManager.getTransaction().commit();
			entityManager.refresh(getTournamentById(tournament.getId()));
			
			List<Match> matches = entityManager.createQuery(
					"SELECT m FROM Match m").getResultList();
			
			for (Match m : matches)
			{
				entityManager.refresh(m);
			}
			
			return getTournamentById(tournament.getId());
		}
		catch (Exception e)
		{	
			if (entityManager.getTransaction().isActive())
			entityManager.getTransaction().rollback();
			
			throw new NotFoundException();
		}
	}

	@Override
	public List<Match> getTournamentMatches(Long tournamentId) {
		
		EntityManager entityManager = DatabaseManager.getEntityManager();
		
		try
		{
			String tournament = (String) entityManager.createQuery(
				    "SELECT t.tournamentName FROM Tournament t where t.id = :tournamentId")
				    .setParameter("tournamentId", tournamentId)
				    .getSingleResult();
			
			if (tournament == null) 
			{
				throw new NotFoundException();
			}
			
			return entityManager.createQuery(
				    "SELECT m FROM Match m where m.tournamentName LIKE :tournament")
				    .setParameter("tournament", tournament)
				    .getResultList();
		}
		catch (Exception e)
		{	
			throw new NotFoundException();
		}
	}

}
