package pl.edu.amu.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseManager {
	
	private static EntityManager entityManager;
	
	public static EntityManager getEntityManager() {
        if (entityManager == null) 
        { 
        	EntityManagerFactory factory = Persistence.createEntityManagerFactory("cuteEntityManager");
        	entityManager = factory.createEntityManager();
        }
        
        return entityManager;
	}
	
	
	
}
