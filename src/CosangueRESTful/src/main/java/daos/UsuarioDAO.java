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

	@SuppressWarnings("unchecked")
	public Usuario verificaLogin(Usuario usuario) {
		try {
			entityManager.getTransaction().begin();
			Query buscaUsuario = entityManager
					.createQuery("Select u from Usuario u where u.login like :login");
			buscaUsuario.setParameter("login", usuario.getLogin());
			List<Usuario> retorno = buscaUsuario.getResultList();
			entityManager.getTransaction().commit();
			if (retorno.isEmpty()) {
				return null;
			} else {
				return retorno.get(0);

			}
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public Usuario autenticaLogin(String login, String senha) {
		try {
			entityManager.getTransaction().begin();
			Query buscaUsuario = entityManager
					.createQuery("SELECT u FROM Usuario u WHERE u.login LIKE :login AND senha LIKE :senha");
			buscaUsuario.setParameter("login", login);
			buscaUsuario.setParameter("senha", senha);
			// System.out.println(login);
			List<Usuario> retorno = buscaUsuario.getResultList();
			entityManager.getTransaction().commit();
			if (retorno.isEmpty()) {
				return null;
			} else {

				// System.out.println(retorno.get(0).getIdade());
				// System.out.println(retorno.get(0).getNome());
				// System.out.println(retorno.get(0).getLogin());
				return retorno.get(0);

			}
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return null;
		}

	}
}
