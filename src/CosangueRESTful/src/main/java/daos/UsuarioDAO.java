package daos;

import java.util.List;

import javax.persistence.Query;

import managers.SimpleEntityManager;
import pojos.Doacao;
import pojos.Usuario;

public class UsuarioDAO extends SimpleEntityManager {

	@SuppressWarnings("unchecked")
	public Usuario verificaLogin(Usuario usuario) {
		try {
			beginTransaction();
			final Query query = entityManager
					.createQuery("Select u from Usuario u where u.login like :login");
			query.setParameter("login", usuario.getLogin());
			List<Usuario> retorno = query.getResultList();
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
			final Query query = entityManager
					.createQuery("SELECT u FROM Usuario u WHERE u.login LIKE :login AND senha LIKE :senha");
			query.setParameter("login", login);
			query.setParameter("senha", senha);
			// System.out.println(login);
			List<Usuario> retorno = query.getResultList();
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

	public Usuario incrementaDoacaoDoUsuario(Long idUsuario, Long idDoacao) {
		try {
			beginTransaction();
			Usuario usuarioRetornado = entityManager.find(Usuario.class,
					idUsuario);
			Doacao doacaoRetornada = entityManager.find(Doacao.class, idDoacao);
			if (doacaoRetornada != null) {
				Integer qtdadeDoacao = usuarioRetornado.getQuantidadeDoacao();
				qtdadeDoacao = qtdadeDoacao + 1;
				usuarioRetornado.setQuantidadeDoacao(qtdadeDoacao);
				entityManager.merge(usuarioRetornado);
			}
			commit();
			return usuarioRetornado;

		} catch (Exception e) {
			e.printStackTrace();
			rollBack();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public Usuario inseriRegistrationId(Long id, String registrationId) {
		try {
			beginTransaction();
			Usuario retorno = entityManager.find(Usuario.class, id);
			retorno.setRegistrationId(registrationId);
			entityManager.merge(retorno);
			commit();
			return retorno;

		} catch (Exception e) {
			e.printStackTrace();
			rollBack();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public Usuario removeRegistrationId(Long id) {
		try {
			beginTransaction();
			Usuario retorno = entityManager.find(Usuario.class, id);
			retorno.setRegistrationId(null);
			entityManager.merge(retorno);
			commit();
			return retorno;

		} catch (Exception e) {
			e.printStackTrace();
			rollBack();
			return null;
		}
	}

	public List<Usuario> listaRegistrosUsuarios() {
		try {
			beginTransaction();
			final Query query = entityManager
					.createQuery("Select u from Usuario u");
			List<Usuario> retorno = query.getResultList();
			commit();
			if (retorno.isEmpty()) {
				return null;
			} else {
				return retorno;
			}
		} catch (Exception e) {
			e.printStackTrace();
			rollBack();
			return null;
		}
	}
}
