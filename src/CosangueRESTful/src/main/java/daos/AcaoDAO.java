package daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import managers.SimpleEntityManager;
import pojos.Acao;
import pojos.Endereco;
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
	
	@SuppressWarnings("unchecked")
	public void excluiAcao(Long id) {
		try {
			beginTransaction();
			Acao retorno = entityManager.find(Acao.class, id);
			entityManager.remove(retorno);
			commit();
			//return retorno;

		} catch (Exception e) {
			e.printStackTrace();
			rollBack();
			//return null;
		}
	}
	
}
