package pl.edu.amu;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.edu.amu.rest.dto.Match;
import pl.edu.amu.rest.dto.Player;
import pl.edu.amu.rest.dto.ThrowSet;
import pl.edu.amu.rest.dto.Tournament;

public class MatchTest extends TestCase
{
	public void test() {
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Tournament tournament = new Tournament("Super turniej");
		Player player1 = new Player("staszkox", "Pawel Stacherzak", "staszko@staszko");
		Player player2 = new Player("tomeslaw", "Tomasz Grzesiak", "comarch@comarch");
		
		session.save(tournament);
		session.save(player1);
		session.save(player2);
		
		Match match = new Match();
		match.setTournament(tournament);
		
		ThrowSet throwSet = new ThrowSet(player1, match, 1, 13, 10, 15);
		ThrowSet throwSet1 = new ThrowSet(player2, match, 1, 12, 11, 16);
		ThrowSet throwSet2 = new ThrowSet(player1, match, 2, 7, 12, 17);
		ThrowSet throwSet3 = new ThrowSet(player2, match, 2, 8, 9, 17);
		
		session.save(match);
		session.save(throwSet);
		session.save(throwSet1);
		session.save(throwSet2);
		session.save(throwSet3);

		Match secondMatch = new Match();
		secondMatch.setTournament(tournament);
		
		ThrowSet throwSetSecondMatch = new ThrowSet(player1, secondMatch, 1, 10, 21, 22);
		ThrowSet throwSet1SecondMatch = new ThrowSet(player2, secondMatch, 1, 12, 11, 22);
		ThrowSet throwSet2SecondMatch = new ThrowSet(player1, secondMatch, 2, 8, 12, 2);
		ThrowSet throwSet3SecondMatch = new ThrowSet(player2, secondMatch, 2, 19, 10, 17);
		
		session.save(secondMatch);
		session.save(throwSetSecondMatch);
		session.save(throwSet1SecondMatch);
		session.save(throwSet2SecondMatch);
		session.save(throwSet3SecondMatch);

		session.getTransaction().commit();
		session.close();
	}
}
