package utils;

public interface Constantes {
	
	final static String URL_LOGIN_HEMOCENTRO = "http://localhost:8080/CosangueRESTful/hemocentro/{login}/{senha}";
	final static String URL_CRIA_EVENTO = "http://localhost:8080/CosangueRESTful/acao/";
	final static String URL_EXCLUI_EVENTO = "http://localhost:8080/CosangueRESTful/acao/{ID}";
	final static String URL_LISTA_EVENTOS = "http://localhost:8080/CosangueRESTful/acao/";
	final static String URL_CRIA_ENDERECO = "http://localhost:8080/CosangueRESTful/endereco/";
	final static String URL_BUSCA_ACAO = "http://localhost:8080/CosangueRESTful/acao/{ID}";
	final static String URL_BUSCA_ENDERECO = "http://localhost:8080/CosangueRESTful/endereco/{ID}";
	final static String URL_ATUALIZA_ENDERECO = "http://localhost:8080/CosangueRESTful/endereco/{idEndereco}/{idAcao}";
	final static String ROOT_ELEMENT_ACAO = "acao";

}
