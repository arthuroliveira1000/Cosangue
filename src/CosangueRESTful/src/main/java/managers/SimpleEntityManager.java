package managers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SimpleEntityManager {

	protected static EntityManager entityManager;
	protected static EntityManagerFactory factory;
	protected final String PERSISTENCE_UNIT_NAME = "jpa";

	protected SimpleEntityManager() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		this.entityManager = factory.createEntityManager();
	}

	protected SimpleEntityManager(EntityManagerFactory factory) {
		this.factory = factory;
		this.entityManager = factory.createEntityManager();
	}

	protected static void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	protected static void commit() {
		entityManager.getTransaction().commit();
	}

	protected static void close() {
		entityManager.close();
		factory.close();
	}

	protected static void rollBack() {
		entityManager.getTransaction().rollback();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
}
