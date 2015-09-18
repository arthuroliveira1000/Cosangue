package daos;

import javax.persistence.EntityManager;

import pojos.Hemocentro;

public class HemocentroDAO extends GenericDAO<Long, Hemocentro> {

	public HemocentroDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
