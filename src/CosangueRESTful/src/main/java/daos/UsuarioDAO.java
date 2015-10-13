package daos;

import java.util.List;

import javax.persistence.Query;

import managers.SimpleEntityManager;
import pojos.Usuario;

public class UsuarioDAO extends SimpleEntityManager {

	@SuppressWarnings("unchecked")
	public Usuario verificaLogin(Usuario usuario) {
		try {
			beginTransaction();
			Query buscaUsuario = entityManager
					.createQuery("Select u from Usuario u where u.login like :login");
			buscaUsuario.setParameter("login", usuario.getLogin());
			List<Usuario> retorno = buscaUsuario.getResultList();
			commit();
			if (retorno.isEmpty()) {
				return null;
			} else {
				return retorno.get(0);

			}
		} catch (Exception e) {
			e.printStackTrace();
			rollBack();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public Usuario autenticaLogin(String login, String senha) {
		try {
			beginTransaction();
			Query buscaUsuario = entityManager
					.createQuery("SELECT u FROM Usuario u WHERE u.login LIKE :login AND senha LIKE :senha");
			buscaUsuario.setParameter("login", login);
			buscaUsuario.setParameter("senha", senha);
			// System.out.println(login);
			List<Usuario> retorno = buscaUsuario.getResultList();
			commit();
			if (retorno.isEmpty()) {
				return null;
			} else {
				return retorno.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			rollBack();
			return null;
		}
	}
}
