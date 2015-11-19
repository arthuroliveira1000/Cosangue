package daos;

import java.util.ArrayList;

import javax.persistence.Query;

import managers.SimpleEntityManager;
import pojos.Acao;

import pojos.Usuario;

public class AcaoDAO extends SimpleEntityManager {

	public ArrayList<Acao> listaAcoes() {
		try {
			beginTransaction();
			final Query query = entityManager
					.createQuery("Select u from Acao u");
			ArrayList<Acao> retorno = new ArrayList<Acao>();
			retorno = (ArrayList<Acao>) query.getResultList();
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

	public Acao inseriAcaoNoUsuario(Long idAcao, Long idUsuario) {
		try {
			beginTransaction();
			Acao acaoRetornada = entityManager.find(Acao.class, idAcao);
			Usuario usuarioRetornado = entityManager.find(Usuario.class,
					idUsuario);
			acaoRetornada.setUsuario(usuarioRetornado);
			entityManager.merge(acaoRetornada);
			commit();
			return acaoRetornada;
		} catch (Exception e) {
			e.printStackTrace();
			rollBack();
		}
		return null;
	}

	public void excluiAcao(Long id) {
		try {
			beginTransaction();
			Acao retorno = entityManager.find(Acao.class, id);
			entityManager.remove(retorno);
			commit();

		} catch (Exception e) {
			e.printStackTrace();
			rollBack();
		}
	}
}
