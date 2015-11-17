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
	  
	  
	  public void excluir(Long id) {
		  restTemplate.delete(Constantes.URL_EXCLUI_EVENTO, id);
	  }
	  
	  public Acao buscaAcao(Long id) {
		  return restTemplate.getForObject(Constantes.URL_BUSCA_ACAO, Acao.class, id);
	  }
	  
	  public ArrayList<Acao> listaEventos() {
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
