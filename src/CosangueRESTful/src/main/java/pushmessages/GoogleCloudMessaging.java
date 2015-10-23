package pushmessages;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import pojos.Acao;
import pojos.Usuario;
import daos.UsuarioDAO;

public class GoogleCloudMessaging {

	public static String post(String apiKey, String deviceRegistrationId,
			Map<String, String> params) throws IOException {

		// Parametros necessários para o POST
		StringBuilder postBody = new StringBuilder();
		postBody.append("registration_id").append("=")
				.append(deviceRegistrationId);
		// Cria os parâmetros chave=valor -> formato json
		Set<String> keys = params.keySet();

		for (String key : keys) {
			String value = params.get(key);
			postBody.append("&").append("data.").append(key).append("=")
					.append(URLEncoder.encode(value, "UTF-8"));
		}

		// Cria a mensagem
		byte[] postData = postBody.toString().getBytes("UTF-8");
		// Faz POST
		URL url = new URL(Constantes.GOOGLE_SERVER);
		HttpsURLConnection
				.setDefaultHostnameVerifier(new CustomizedHostnameVerifier());
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded;charset=UTF-8");
		conn.setRequestProperty("Content-Length",
				Integer.toString(postData.length));
		conn.setRequestProperty("Authorization", "key=" + apiKey);

		// Lê a resposta
		OutputStream out = conn.getOutputStream();
		out.write(postData);
		out.close();

		// armazena o código do status da requisitação
		int responseCode = conn.getResponseCode();
		if (responseCode == 200) {
			// OK
			String response = conn.getResponseMessage();
			return response;
		} else {
			System.err.println(responseCode + ": " + conn.getResponseMessage());
		}

		return null;
	}

	public static void ExecutaPost(Acao novaAcao) throws IOException {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Map<String, String> mensagem;
		List<Usuario> devicesCadastrados = usuarioDAO.listaRegistrosUsuarios();

		// formata a mensagem
		if (novaAcao.getNome().isEmpty()) {
			mensagem = MensagemToJson.mensagemFormatada("Evento sem título!");
			System.out.println("Mensagem formatada!");
		} else {
			mensagem = MensagemToJson.mensagemFormatada(novaAcao.getNome());
			System.out.println("Mensagem formatada!");
		}

		// verifica se o hemocentro criou a ação e envia para todos os usuários
		if (novaAcao.getHemocentro() != null) {
			System.out.println("Ação criado por um hemocentro!");
			for (Usuario device : devicesCadastrados) {
				if (device.getRegistrationId() != null) {
					GoogleCloudMessaging.post(Constantes.MY_SERVER_KEY,
							device.getRegistrationId(), mensagem);
					System.out
							.println("Mensagem enviada para o registration_id: "
									+ device.getRegistrationId());
				}
			}
			// verifica se o usuário criou a ação e envia para todos os usuários
			// com exceção do que criou a ação
		} else if (novaAcao.getUsuario() != null) {
			System.out.println("Ação criado por um usuário!");
			Usuario criadorAcao = novaAcao.getUsuario();
			for (Usuario device : devicesCadastrados) {
				if (device.getRegistrationId() != null) {
					if (device != criadorAcao) {
						GoogleCloudMessaging.post(Constantes.MY_SERVER_KEY,
								device.getRegistrationId(), mensagem);
						System.out
								.println("Mensagem enviada para o registration_id: "
										+ device.getRegistrationId());
					}
					System.out
							.println("Passando pelo usuário que criou a ação e ignorando-o...");
				}
			}
		}
	}

	private static class CustomizedHostnameVerifier implements HostnameVerifier {
		public boolean verify(String hostname, SSLSession session) {
			return true;
		}
	}
}
