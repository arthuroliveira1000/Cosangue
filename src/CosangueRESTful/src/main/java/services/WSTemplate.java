package services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class WSTemplate {

	private static EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("jpa");

	protected <T> T insert(T object) {
		EntityManager manager = factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.persist(object);
			manager.getTransaction().commit();
			manager.close();
			return object;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			manager = null;
			clean();
		}
	}

	protected <T> T selectOne(Class<T> type, Long ID) {
		EntityManager manager = factory.createEntityManager();
		T object;
		try {
			manager.getTransaction().begin();
			object = manager.find(type, ID);
			manager.getTransaction().commit();
			return object;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			return null;
		} finally {
			object = null;
			manager.close();
			manager = null;
			clean();
		}
	}

	public void clean() {
		System.gc();
	}
}
