package com.min.captain.darts.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.min.captain.darts.application.player.Player;

public final class HibernateUtils 
{
	public static void saveToDb(Player player) 
	{
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
 
		session.save(player);
 
		session.getTransaction().commit();
		session.close();
	}
}
