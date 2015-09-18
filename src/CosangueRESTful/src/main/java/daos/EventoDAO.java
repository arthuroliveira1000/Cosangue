package daos;

import javax.persistence.EntityManager;

import pojos.Evento;

public class EventoDAO extends GenericDAO<Long, Evento> {

	public EventoDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
