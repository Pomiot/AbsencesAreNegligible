package com.min.captain.darts.utils;

import junit.framework.TestCase;

import org.hibernate.Session;

import com.min.captain.darts.application.match.Match;
import com.min.captain.darts.application.player.Player;
import com.min.captain.darts.application.throwSet.ThrowSet;

public class HibernateUtilsTest extends TestCase {
	
	public void test()
	{
		Session session = HibernateUtils.createAndOpenSession();
		
		Player player = new Player("Allegro", "Jest najlepsze");
		Match match = new Match();
		
		ThrowSet throwSet = new ThrowSet(player, match, 1, 10, 15, 20);
		ThrowSet throwSet1 = new ThrowSet(player, match, 2, 10, 15, 20);
		ThrowSet throwSet2 = new ThrowSet(player, match, 3, 10, 15, 20);
		
		HibernateUtils.saveToDb(session, player, match, throwSet, throwSet1, throwSet2);
		HibernateUtils.commit(session);
		HibernateUtils.close(session);
	}
}
