package daos;

import javax.persistence.EntityManager;

import entities.Acao;

public class AcaoDAO extends GenericDAO<Long, Acao> {

	public AcaoDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
