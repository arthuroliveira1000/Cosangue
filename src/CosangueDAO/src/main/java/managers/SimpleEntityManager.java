package managers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * @author gabriel  
 */

public class SimpleEntityManager {

	private EntityManager entityManager;
	private EntityManagerFactory factory;
	private final String PERSISTENCEUNITNAME = "jpa";

	public SimpleEntityManager() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCEUNITNAME);
		this.entityManager = factory.createEntityManager();
	}

	public SimpleEntityManager(EntityManagerFactory factory) {
		this.factory = factory;
		this.entityManager = factory.createEntityManager();
	}

	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	public void commit() {
		entityManager.getTransaction().commit();
	}

	public void close() {
		entityManager.close();
		factory.close();
	}

	public void rollBack() {
		entityManager.getTransaction().rollback();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
}
