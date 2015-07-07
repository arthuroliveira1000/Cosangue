package daos;

import javax.persistence.EntityManager;

import entities.Evento;

public class EventoDAO extends GenericDAO<Long, Evento> {

	public EventoDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
