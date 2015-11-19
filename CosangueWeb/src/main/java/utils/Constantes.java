package utils;

public interface Constantes {
	final static String URL = "http://projetos.sapucaia.ifsul.edu.br:8080/CosangueRESTful/";
	final static String URL_LOGIN_HEMOCENTRO = URL + "hemocentro/{login}/{senha}";
	final static String URL_CRIA_EVENTO = "http://localhost:8080/CosangueRESTful/acao/";
	final static String URL_EXCLUI_EVENTO = "http://localhost:8080/CosangueRESTful/acao/{ID}";
	final static String URL_LISTA_EVENTOS = URL + "acao/";
	final static String URL_CRIA_ENDERECO = "http://localhost:8080/CosangueRESTful/endereco/";
	final static String URL_BUSCA_ACAO = "http://localhost:8080/CosangueRESTful/acao/{ID}";
	final static String URL_BUSCA_ENDERECO = "http://localhost:8080/CosangueRESTful/endereco/{ID}";
	final static String URL_INSERE_ACAO_NO_ENDERECO = "http://localhost:8080/CosangueRESTful/endereco/{idEndereco}/{idAcao}";
	final static String URL_BUSCA_ACAO_POR_HEMOCENTRO = URL + "/acao/listaAcao/{ID}";
	final static String URL_ATUALIZA_ENDERECO = "http://localhost:8080/CosangueRESTful/endereco/";
	final static String URL_ATUALIZA_ACAO = "http://localhost:8080/CosangueRESTful/acao/";
	final static String ROOT_ELEMENT_ACAO = "acao";

}
