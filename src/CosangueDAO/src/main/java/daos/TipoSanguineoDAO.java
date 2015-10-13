package daos;

import javax.persistence.EntityManager;

import entities.Sangue;

public class TipoSanguineoDAO extends GenericDAO<Long, Sangue>{

	public TipoSanguineoDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
