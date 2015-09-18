package daos;

import javax.persistence.EntityManager;

import pojos.Doacao;

public class DoacaoDAO extends GenericDAO<Long, Doacao> {

	public DoacaoDAO(EntityManager entityManager) {
		super(entityManager);
	}

}
