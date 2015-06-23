package daos;

import javax.persistence.EntityManager;

import pojos.TipoSanguineo;

public class TipoSanguineoDAO extends GenericDAO<Long, TipoSanguineo>{

	public TipoSanguineoDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
