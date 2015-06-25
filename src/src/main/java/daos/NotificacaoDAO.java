package daos;

import javax.persistence.EntityManager;

import entities.Notificacao;

public class NotificacaoDAO extends GenericDAO<Long, Notificacao>{

	public NotificacaoDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
