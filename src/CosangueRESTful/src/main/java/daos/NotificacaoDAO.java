package daos;

import javax.persistence.EntityManager;

import pojos.Notificacao;

public class NotificacaoDAO extends GenericDAO<Long, Notificacao> {

	public NotificacaoDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
