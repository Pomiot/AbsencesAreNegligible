package pl.edu.amu.repositoryImplementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.NotFoundException;

import pl.edu.amu.database.DatabaseManager;
import pl.edu.amu.database.PlayerRepository;
import pl.edu.amu.rest.dto.Player;

public class PlayerRepositoryImpl implements PlayerRepository {

	@Override
	public List<Player> getAllPlayers() {

		EntityManager entityManager = DatabaseManager.getEntityManager();

		return entityManager.createQuery(
			    "SELECT p FROM Player p")
			    .getResultList();
	}

	@Override
	public Player getPlayerByLogin(String login) throws NotFoundException {
		EntityManager entityManager = DatabaseManager.getEntityManager();

		try
		{
			return (Player) entityManager.createQuery(
					"SELECT p FROM Player p WHERE p.login LIKE :login")
					.setParameter("login", login)
					.getSingleResult();
		}
		catch (Exception e)
		{
			throw new NotFoundException();
		}
	}

	@Override
	public boolean addPlayer(Player player) {

		boolean result = false;

		EntityManager entityManager = DatabaseManager.getEntityManager();
		try
		{
			entityManager.getTransaction().begin();
			entityManager.persist(player);
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
	public boolean deletePlayer(String login) {

		EntityManager entityManager = DatabaseManager.getEntityManager();

		try
		{
			entityManager.getTransaction().begin();
			entityManager.remove(getPlayerByLogin(login));
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
	public Player updatePlayer(Player player) {
		
		EntityManager entityManager = DatabaseManager.getEntityManager();
		
		try
		{
			entityManager.getTransaction().begin();
			
			entityManager.createQuery(
					"UPDATE Player p SET p.name = :newName , p.email = :newEmail WHERE p.login LIKE :login")
					.setParameter("login", player.getLogin())
					.setParameter("newName", player.getName())
					.setParameter("newEmail", player.getEmail())
					.executeUpdate();
			
			entityManager.getTransaction().commit();
			entityManager.refresh(getPlayerByLogin(player.getLogin()));
			return getPlayerByLogin(player.getLogin());
		}
		catch (Exception e)
		{	
			entityManager.getTransaction().rollback();
			
			throw new NotFoundException();
		}
	}
}
