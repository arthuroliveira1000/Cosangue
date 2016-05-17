package cosangue.dao;

import resttemplate.SimpleRestTemplate;
import utils.Constantes;
import cosangue.model.Endereco;

public class EnderecoDAO extends SimpleRestTemplate {
	
	public Endereco inserir(Endereco... params) {
		  return restTemplate.postForObject(Constantes.URL_CRIA_ENDERECO, params[0], Endereco.class);
	    }
	
	 public Endereco buscaEndereco(Endereco... params) {
		  return restTemplate.getForObject(Constantes.URL_BUSCA_ENDERECO, Endereco.class, params[0].getId());
	  }
	
	 public void inseriAcaoNoEndereco(String... params) {
		  restTemplate.put(Constantes.URL_INSERE_ACAO_NO_ENDERECO, Endereco.class, params);
	}
	 
	 public void atualizaEndereco(Endereco...params) {
		  restTemplate.put(Constantes.URL_ATUALIZA_ENDERECO, params[0], Endereco.class);
	}
	 
	
}
