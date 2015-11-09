package tcc.cosangueapp.utils;

public interface Constantes {

    final String URL_USUARIO_LOGIN = "http://192.168.0.103:8080/CosangueRESTful/usuario/{login}/{senha}";
    final String URL_USUARIO = "http://192.168.0.103:8080/CosangueRESTful/usuario";
    final String URL_USUARIO_ID = "http://192.168.0.103:8080/CosangueRESTful/usuario/{id}";
    final String URL_USUARIO_ATUALIZA_REG_ID = "http://192.168.0.103:8080/CosangueRESTful/usuario/{id}/{registration_id}";


    final String URL_ACAO = "http://192.168.0.103:8080/CosangueRESTful/acao";
    final String URL_ACAO_ID = "http://192.168.0.103:8080/CosangueRESTful/acao/{id}";



    final String ROOT_ELEMENT_ACAO = "acao";
    final static String NOME_SHARED_PREFERENCIES = "preferencias_usuario";



    final String TAG = "gcm";
    final String PROPERTY_REG_ID = "registration_id";
    final String SENDER_ID = "1093440715360";
}
