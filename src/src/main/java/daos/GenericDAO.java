package daos;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

@SuppressWarnings("unchecked")
public class GenericDAO<PK, T> {

	private EntityManager entityManager;

	public GenericDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void save(T entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
		// getTypeClass().getName();
	}

	public void update(T entity) {
		entityManager.getTransaction().begin();
		entityManager.getTransaction().commit();
		entityManager.merge(entity);
		entityManager.close();
	}

	public void delete(T entity) {
		entityManager.getTransaction().begin();
		entityManager.getTransaction().commit();
		entityManager.remove(entity);
		entityManager.close();
	}

	public List<T> findAll() {
		return entityManager.createQuery(("FROM " + getTypeClass().getName()))
				.getResultList();
	}

	public T getById(PK pk) {
		return (T) entityManager.find(getTypeClass(), pk);
	}

	private Class<?> getTypeClass() {
		Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[1];
		return clazz;
	}
}
