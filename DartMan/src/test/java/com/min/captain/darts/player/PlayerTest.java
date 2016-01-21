package com.min.captain.darts.player;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PlayerTest extends TestCase {
	 
	public void testApp() {
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
 
		Player user = new Player("first", "last");
		session.save(user);
 
		session.getTransaction().commit();
		session.close();
	}
}