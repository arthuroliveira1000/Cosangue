package daos;

import managers.SimpleEntityManager;
import pojos.Acao;
import pojos.Endereco;

public class EnderecoDAO extends SimpleEntityManager {
	
	public Endereco inseriAcaoNoEndereco(Long idEndereco, Long idAcao) {
		try {
			beginTransaction();
			Endereco retorno = entityManager.find(Endereco.class, idEndereco);
			Acao acaoRetornada = entityManager.find(Acao.class, idAcao);
			retorno.setAcao(acaoRetornada);							
			entityManager.merge(retorno);
			commit();
			return retorno;

		} catch (Exception e) {
			e.printStackTrace();
			rollBack();
		}
		return null;
	}

}
