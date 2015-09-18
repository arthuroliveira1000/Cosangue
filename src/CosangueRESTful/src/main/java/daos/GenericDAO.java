package daos;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SuppressWarnings("unchecked")
abstract class GenericDAO<PK, T> {

	protected EntityManagerFactory factory;
	protected EntityManager entityManager;
	protected final String PERSISTENCEUNITNAME = "jpa";

	public GenericDAO(EntityManager entityManager) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCEUNITNAME);
		this.entityManager = factory.createEntityManager();
	}

	public void save(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void update(T entity) {
		entityManager.merge(entity);
	}

	public void delete(T entity) {
		entityManager.remove(entity);
	}

	public List<T> findAll() {
		return entityManager.createQuery(("FROM " + getTypeClass().getName()))
				.getResultList();
	}

	public T getById(PK pk) {
		try {
			entityManager.getTransaction().begin();
			return (T) entityManager.find(getTypeClass(), pk);
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return null;
	}

	private Class<?> getTypeClass() {
		Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[1];
		return clazz;
	}

}
