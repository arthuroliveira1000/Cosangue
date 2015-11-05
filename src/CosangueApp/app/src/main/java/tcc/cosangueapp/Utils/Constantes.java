package tcc.cosangueapp.utils;

public interface Constantes {

    final String URL_USUARIO_LOGIN = "http://192.168.0.102:8080/CosangueRESTful/usuario/{login}/{senha}";
    final String URL_USUARIO = "http://192.168.0.102:8080/CosangueRESTful/usuario";
    final String URL_USUARIO_ID = "http://192.168.0.102:8080/CosangueRESTful/usuario/{id}";
    final String URL_USUARIO_ATUALIZA_REG_ID = "http://192.168.0.102:8080/CosangueRESTful/usuario/{id}/{registration_id}";



    final static String NOME_SHARED_PREFERENCIES = "preferencias_usuario";

    // ifsap13 - 192.168.240.71
    // casa - 192.168.240.71
    //0.100

    //0.102 - casa


    final String TAG = "gcm";
    final String PROPERTY_REG_ID = "registration_id";
    final String SENDER_ID = "1093440715360";
}
