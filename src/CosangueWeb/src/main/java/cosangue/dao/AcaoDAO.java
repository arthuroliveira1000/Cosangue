package cosangue.dao;

import java.util.ArrayList;
import java.util.Arrays;

import json.Json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import resttemplate.SimpleRestTemplate;
import utils.Constantes;

import com.google.gson.Gson;

import cosangue.model.Acao;

public class AcaoDAO extends SimpleRestTemplate {
	public Acao inserir(Acao... params) {
		return restTemplate.postForObject(Constantes.URL_CRIA_EVENTO,
				params[0], Acao.class);
	}

	public void atualizar(Acao... params) {
		restTemplate.put(Constantes.URL_ATUALIZA_ACAO, params[0], Acao.class);
	}

	public void excluir(Long id) {
		restTemplate.delete(Constantes.URL_EXCLUI_EVENTO, id);
	}

	public Acao buscaAcao(Long id) {
		return restTemplate.getForObject(Constantes.URL_BUSCA_ACAO, Acao.class,
				id);
	}

	public ArrayList<Acao> listaEventos() {
		ArrayList<Acao> acao = new ArrayList<Acao>();
		Gson gson = new Gson();

		try {
			JSONObject resposta = Json.get(Constantes.URL_LISTA_EVENTOS);
			JSONArray array = resposta
					.getJSONArray(Constantes.ROOT_ELEMENT_ACAO);
			for (int i = 0; i < array.length(); i++) {
				acao.add(gson.fromJson(array.get(i).toString(), Acao.class));
			}
			return acao;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;

	}

	public ArrayList<Acao> buscaAcoesPorHemocentro(Long id) {

		String URL = Constantes.URL_BUSCA_ACAO_POR_HEMOCENTRO;

		ArrayList<Acao> listaAcoes = new ArrayList<Acao>();
		Gson gson = new Gson();
		JSONObject response = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setAccept(Arrays.asList(MediaType.ALL));

		HttpEntity<String> entity = new HttpEntity<>(headers);
		try {

			ResponseEntity<String> entityResponse = restTemplate.exchange(URL,
					HttpMethod.GET, entity, String.class, id);
			String stringResponse = entityResponse.getBody();

			if (stringResponse != null) {
				response = new JSONObject(stringResponse);
				JSONArray array = response.getJSONArray("acao");
				if (array == null) {
				} else {
					for (int i = 0; i < array.length(); i++) {
						listaAcoes.add(gson.fromJson(array.get(i).toString(),
								Acao.class));
					}
				}
			} else {
				return listaAcoes;
			}

		} catch (JSONException e) {
			try {
				String unicaAcao = response.getJSONObject("acao").toString();
				listaAcoes.add(gson.fromJson(unicaAcao, Acao.class));

			} catch (JSONException jE) {
				jE.printStackTrace();
			}
		}
		return listaAcoes;
	}
}
