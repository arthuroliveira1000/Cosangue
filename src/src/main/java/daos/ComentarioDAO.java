package daos;

import javax.persistence.EntityManager;

import entities.Comentario;

public class ComentarioDAO extends GenericDAO<Long, Comentario> {

	public ComentarioDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
