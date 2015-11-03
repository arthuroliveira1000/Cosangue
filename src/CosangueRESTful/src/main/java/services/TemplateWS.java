package services;

import managers.SimpleEntityManager;

public class TemplateWS extends SimpleEntityManager {

	protected <T> T insert(T object) {
		try {
			beginTransaction();
			entityManager.persist(object);
			commit();
			close();
			return object;
		} catch (Exception e) {
			rollBack();
			e.printStackTrace();
			return null;
		} finally {
			entityManager = null;
			clean();
		}
	}

	protected <T> T selectOne(Class<T> type, Long ID) {
		T object;
		try {
			beginTransaction();
			object = entityManager.find(type, ID);
			commit();
			return object;
		} catch (Exception e) {
			rollBack();
			return null;
		} finally {
			object = null;
			close();
			entityManager = null;
			clean();
		}
	}
	
	protected <T> T update(T object) {
		try {
			beginTransaction();
			entityManager.merge(object);
			commit();
			close();
			return object;
		} catch (Exception e) {
			rollBack();
			e.printStackTrace();
			return null;
		} finally {
			entityManager = null;
			clean();
		}
	}
	
	protected <T> T delete(T object) {
		try {
			beginTransaction();
			entityManager.remove(object);
			commit();
			close();
			return object;
		} catch (Exception e) {
			rollBack();
			e.printStackTrace();
			return null;
		} finally {
			entityManager = null;
			clean();
		}
	}

	public void clean() {
		System.gc();
	}
}
