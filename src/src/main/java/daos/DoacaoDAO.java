package daos;

import javax.persistence.EntityManager;

import entitys.Doacao;

public class DoacaoDAO extends GenericDAO <Long, Doacao>{

	public DoacaoDAO(EntityManager entityManager) {
		super(entityManager);
	}

}
