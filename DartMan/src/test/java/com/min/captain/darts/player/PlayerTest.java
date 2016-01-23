package com.min.captain.darts.player;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.min.captain.darts.application.player.Player;

public class PlayerTest {
	 
	public void testApp() {
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Player user = new Player("firstTest", "lastTest");
		
		session.save(user);
 
		session.getTransaction().commit();
		session.close();
	}
}
