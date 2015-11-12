package cosangue.dao;

import java.util.ArrayList;

import json.Json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import resttemplate.SimpleRestTemplate;
import utils.Constantes;

import com.google.gson.Gson;

import cosangue.model.Acao;

public class AcaoDAO extends SimpleRestTemplate {
	  public Acao inserir(Acao... params) {
		  
		  return restTemplate.postForObject(Constantes.URL_CRIA_EVENTO, params[0], Acao.class);
	    }
	  
	  public Acao excluir(Acao... params) {
		  return restTemplate.getForObject(Constantes.URL_EXCLUI_EVENTO, Acao.class, params);
	  }
	  
	  public Acao buscaAcao(Acao... params) {
		  return restTemplate.getForObject(Constantes.URL_BUSCA_ACAO, Acao.class, params[0].getId());
	  }
	  
	  public ArrayList<Acao> listaEventos() {
		 // ResponseEntity<Acao[]> responseEntity = restTemplate.getForEntity(Constantes.URL_LISTA_EVENTOS, Acao[].class);
		 // List<Acao> acoes = Arrays.asList(responseEntity.getBody());
		 // return acoes;  
		  //return (List<Acao>) restTemplate.getForEntity(Constantes.URL_LISTA_EVENTOS, Acao[].class);
		 // List<Acao> acoes = (List<Acao>) restTemplate.getForObject(Constantes.URL_LISTA_EVENTOS, ListaAcoes.class);
		
		//  ResponseEntity<AcoesJson[]> entity = restTemplate.getForEntity(Constantes.URL_LISTA_EVENTOS, AcoesJson[].class);
	      //  List<AcoesJson> acoes = Arrays.asList(entity.getBody());
		  ArrayList<Acao> acao = new ArrayList<Acao>();
		  Gson gson = new Gson();
		  
		  try {
			  JSONObject resposta = Json.get(Constantes.URL_LISTA_EVENTOS);
			  JSONArray array = resposta.getJSONArray(Constantes.ROOT_ELEMENT_ACAO);
			  for (int i = 0; i < array.length(); i++) {
				  acao.add(gson.fromJson(array.get(i).toString(), Acao.class));
			  }
			  return acao;
		  } catch (JSONException e) {
			  e.printStackTrace();
		  }
		return null;
		  
		  
	  }
	  
}
