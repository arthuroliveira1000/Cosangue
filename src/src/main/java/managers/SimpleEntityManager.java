package managers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * @author gabriel   
 * This class encapsulates some work of EntityManager and EntityManagerFactory as rollback and commit, doing only the essential
 */

public class SimpleEntityManager {

	private EntityManager entityManager;
	private EntityManagerFactory factory;

	public SimpleEntityManager(EntityManagerFactory factory) {
		this.factory = factory;
		this.entityManager = factory.createEntityManager();
	}

	public SimpleEntityManager(String persistenceUnitName) {
		factory = Persistence.createEntityManagerFactory(persistenceUnitName);
		this.entityManager = factory.createEntityManager();
	}

	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	public void commit() {
		entityManager.getTransaction().commit();
	}

	/**
	 * THIS METHOD NEEDS TO BE ALWAYS CALLED TO CLOSE THE CONNECTION WITH THE
	 * BATABASE
	 */
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
