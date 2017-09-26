package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
	
	private static final String PERSISTENCE_UNIT_NAME = "hibernate-persistence";
	private static EntityManagerFactory FACTORY;
	private static ThreadLocal<EntityManager> MANAGER = new ThreadLocal<EntityManager>();
	
	static {
		if(FACTORY == null) {
			try {
				FACTORY = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			} catch(Throwable e) {
				System.out.println("A criação do EntityManagerFactory falhou: " + e);
				throw new ExceptionInInitializerError(e);
			}
		}
	}
	
	public static EntityManager getEntityManager() {
		EntityManager em = MANAGER.get();
		if(em == null) {
			em = FACTORY.createEntityManager();
			MANAGER.set(em);
		}
		return em;
	}
	
	public static void closeEntityManager() {
		EntityManager em = MANAGER.get();
		if(em != null)
			em.close();
		MANAGER.set(null);
	}
	
}
