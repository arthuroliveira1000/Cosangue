package tcc.cosangueapp.utils;

public interface Constantes {

    final String URL_PADRAO = "http://projetos.sapucaia.ifsul.edu.br:8080/CosangueRESTful/";
    final String URL_USUARIO_LOGIN = URL_PADRAO + "usuario/{login}/{senha}";
    final String URL_USUARIO = URL_PADRAO + "usuario";
    final String URL_USUARIO_ID = URL_PADRAO + "usuario/{id}";
    final String URL_USUARIO_ATUALIZA_REG_ID = URL_PADRAO + "usuario/{id}/{registration_id}";
    final String URL_ACAO = URL_PADRAO + "acao";
    final String URL_ACAO_ID = URL_PADRAO + "acao/{id}";
    final String URL_ACAO_USUARIO = URL_PADRAO + "acao/{idAcao}/{idUsuario}";
    final String URL_ENDERECO = URL_PADRAO + "endereco";
    final String URL_ATUALIZA_ENDERECO = URL_PADRAO + "endereco/{idEndereco}/{idAcao}";
    final String ROOT_ELEMENT_ACAO = "acao";
    final static String NOME_SHARED_PREFERENCIES = "preferencias_usuario";
    final String TAG = "gcm";
    final String PROPERTY_REG_ID = "registration_id";
    final String SENDER_ID = "1093440715360";
    final String API_NOT_CONNECTED = "Google API not connected";
    final String SOMETHING_WENT_WRONG = "OOPs!!! Something went wrong...";
    final String PlacesTag = "Google Places Auto Complete";
}
