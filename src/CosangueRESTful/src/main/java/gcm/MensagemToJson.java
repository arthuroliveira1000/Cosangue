package gcm;

import java.util.HashMap;
import java.util.Map;

import pojos.Acao;

public class MensagemToJson {

	public static Map<String, String> mensagemFormatada(Acao acao) {
		Map<String, String> params = new HashMap<String, String>();
		if (acao.getId() != null)
			params.put("id", acao.getId().toString());
		if (acao.getNome() != null)
			params.put("nome", acao.getNome());
		if (acao.getDescricao() != null)
			params.put("descricao", acao.getDescricao());
		if (acao.getData() != null)
			params.put("data", acao.getData());
		if (acao.getHorario() != null)
			params.put("horario", acao.getHorario());
		if (acao.getCategoria() != null)
			params.put("categoria", acao.getCategoria().toString());
		if (acao.getHemocomponente() != null)
			params.put("hemocomponente", acao.getHemocomponente().toString());
		if (acao.getTipo() != null)
			params.put("tiposanguineo", acao.getTipo().toString());

		if (acao.getEndereco() != null) {

			if (acao.getEndereco().getId() != null)
				params.put("id_endereco", acao.getEndereco().getId().toString());
			if (acao.getEndereco().getEnderecoCompleto() != null)
				params.put("enderecoCompleto", acao.getEndereco()
						.getEnderecoCompleto());
			if (acao.getEndereco().getLogradouro() != null)
				params.put("logradouro", acao.getEndereco().getLogradouro());
			if (acao.getEndereco().getBairro() != null)
				params.put("bairro", acao.getEndereco().getBairro());
			if (Integer.toString(acao.getEndereco().getNr()) != null)
				params.put("numero",
						Integer.toString(acao.getEndereco().getNr()));
			if (acao.getEndereco().getCidade() != null)
				params.put("cidade", acao.getEndereco().getCidade());
			if (acao.getEndereco().getUf() != null)
				params.put("uf", acao.getEndereco().getUf());
			if (acao.getEndereco().getLatitude() != null)
				params.put("latitude", acao.getEndereco().getLatitude());
			if (acao.getEndereco().getLongitude() != null)
				params.put("longitude", acao.getEndereco().getLongitude());
		}
		System.out.println("Mensagem Enviada: " + params.toString());
		return params;
	}

}
