package daos;

import javax.persistence.EntityManager;

import pojos.Usuario;

public class UsuarioDAO extends GenericDAO<Long, Usuario> {

	public UsuarioDAO(EntityManager entityManager) {
		super(entityManager);
		
	}

}
