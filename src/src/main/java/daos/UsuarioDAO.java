package daos;

import javax.persistence.EntityManager;

import entitys.Usuario;

public class UsuarioDAO extends GenericDAO<Long, Usuario> {

	public UsuarioDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}
}
