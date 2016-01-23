package com.min.captain.darts.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.min.captain.darts.application.match.Match;
import com.min.captain.darts.application.player.Player;
import com.min.captain.darts.application.throwSet.ThrowSet;
import com.min.captain.darts.application.tournament.Tournament;

public final class HibernateUtils 
{
	public static Session createAndOpenSession() {

		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		return session;
	}
	
	public static void saveToDb(Session session, Object... objects) {
		
		session.beginTransaction();
 
		for (Object object : objects) 
		{
			if (object instanceof Player || object instanceof Match 
					|| object instanceof ThrowSet || object instanceof Tournament)
			{
				session.save(object);
			}
		}
	}
	
	public static void commit(Session session) {
		session.getTransaction().commit();
	}
	
	public static void close(Session session) {
		session.close();
	}
}
