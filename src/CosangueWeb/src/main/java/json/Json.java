package json;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

import cosangue.model.Acao;
import cosangue.model.Endereco;
import cosangue.model.Hemocentro;

public class Json {
	public static JSONObject hemocentroToJson(Hemocentro hemocentro) {
		JSONObject jsonHemocentro = new JSONObject();
		jsonHemocentro.put("id", hemocentro.getId());
		jsonHemocentro.put("nome", hemocentro.getNome());
		jsonHemocentro.put("telefone", hemocentro.getTelefone());
		jsonHemocentro.put("login", hemocentro.getLogin());
		jsonHemocentro.put("senha", hemocentro.getSenha());
		jsonHemocentro.put("endereco", hemocentro.getEndereco());
		//jsonHemocentro.put("acao", hemocentro.getAcao());
		return jsonHemocentro;
	}
	
	public static JSONObject enderecoToJson(Endereco endereco) {
		JSONObject jsonEndereco = new JSONObject();
		jsonEndereco.put("id", endereco.getId());
		jsonEndereco.put("logradouro", endereco.getLogradouro());
		jsonEndereco.put("bairro", endereco.getBairro());
		jsonEndereco.put("cidade", endereco.getCidade());
		jsonEndereco.put("nr", endereco.getNr());
		jsonEndereco.put("cidade", endereco.getCidade());
		jsonEndereco.put("uf", endereco.getUf());
		jsonEndereco.put("latitude", endereco.getLatitude());
		jsonEndereco.put("longitude", endereco.getLongitude());
		jsonEndereco.put("acao", endereco.getAcao());
		return jsonEndereco;
	}
	
	public static JSONObject acaoToJson(Acao acao) {
		JSONObject jsonAcao = new JSONObject();
		jsonAcao.put("id", acao.getId());
		jsonAcao.put("nome", acao.getNome());
		jsonAcao.put("descricao", acao.getDescricao());
		jsonAcao.put("data", acao.getData());
		jsonAcao.put("horario", acao.getHorario());
		jsonAcao.put("nParticipantes", acao.getnParticipantes());
		jsonAcao.put("nReportacoes", acao.getnReportacoes());
		jsonAcao.put("categoria", acao.getCategoria());
		jsonAcao.put("tipo", acao.getTipo());
		jsonAcao.put("hemocomponente", acao.getHemocomponente());
	    jsonAcao.put("endereco", acao.getEndereco());
		jsonAcao.put("hemocentro", acao.getHemocentro());
		return jsonAcao;
	}
	
	public static JSONObject loginToJson(String login, String senha) {
		JSONObject jsonLogin = new JSONObject();
		jsonLogin.put("login", login);
		jsonLogin.put("senha", senha);
		return jsonLogin;
	}
	
	public static JSONObject enderecoAcaoToJson(Long id, Acao acao) {
		JSONObject jsonEnd = new JSONObject();
		jsonEnd.put("id", id);
		jsonEnd.put("acao", acao);
		return jsonEnd;
	}
	
	private static String readAll(Reader reader) throws IOException {
		StringBuilder text = new StringBuilder();
		int count;
		while ((count = reader.read()) != -1) {
			text.append((char) count);
		}
		return text.toString();
	}

	private static JSONObject readJsonFromUrl(String URL) throws IOException, JSONException {
		InputStream inputStream = new URL(URL).openStream();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
			String text = readAll(reader);
			JSONObject jsonObject = new JSONObject(text);
			return jsonObject;
		} finally {
			inputStream.close();
		}
	}

	public static JSONObject get(String URL) {
		try {
			return readJsonFromUrl(URL);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
