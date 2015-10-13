package managers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SimpleEntityManager {

	protected EntityManager entityManager;
	protected EntityManagerFactory factory;
	protected final String PERSISTENCE_UNIT_NAME = "jpa";

	public SimpleEntityManager() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
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
