package daos;

import java.util.List;

import javax.persistence.Query;

import managers.SimpleEntityManager;
import pojos.Acao;
import pojos.Endereco;
import pojos.Usuario;

public class EnderecoDAO extends SimpleEntityManager {
	
	public Endereco insereAcaoNoEndereco(Long idEndereco, Long idAcao) {
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
	
	public Endereco atualizaEndereco(Endereco endereco) {
		try {
			beginTransaction();
			 Endereco retorno = entityManager.find(Endereco.class, endereco.getId());
			 if (retorno != null) {
				 retorno.setCidade(endereco.getCidade());
				 retorno.setLogradouro(endereco.getLogradouro());
				 retorno.setEnderecoCompleto(endereco.getEnderecoCompleto());
				 retorno.setNr(endereco.getNr());
				 retorno.setUf(endereco.getUf());
				 entityManager.merge(retorno);
				 commit();
				 return retorno;				 
			 }

		} catch (Exception e) {
			e.printStackTrace();
			rollBack();
		}
		return null;
	}

}
