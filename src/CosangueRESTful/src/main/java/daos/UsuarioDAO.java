package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pojos.Usuario;

public class UsuarioDAO extends GenericDAO<Long, Usuario> {
	public UsuarioDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public List<Usuario> verificaLogin(Usuario usuario) {
		try {
			entityManager.getTransaction().begin();
			Query buscaUsuario = entityManager
					.createQuery("Select u from Usuario u where u.login like :login");
			buscaUsuario.setParameter("login", usuario.getLogin());
			List<Usuario> retorno = buscaUsuario.getResultList();
			entityManager.getTransaction().commit();
			return retorno;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return null;
		}

	}
}
