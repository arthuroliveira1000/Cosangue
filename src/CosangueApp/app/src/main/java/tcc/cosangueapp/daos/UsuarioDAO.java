package tcc.cosangueapp.daos;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import tcc.cosangueapp.pojos.Usuario;
import tcc.cosangueapp.utils.Constantes;

public class UsuarioDAO extends SimpleRestTemplate {

    public Usuario login(String... params) {
        return inicializaRestTemplate().getForObject(Constantes.URL_USUARIO_LOGIN, Usuario.class, params);
    }

    public Usuario post(Usuario... params) {
        return inicializaRestTemplate().postForObject(Constantes.URL_USUARIO, params[0], Usuario.class);
    }

    public void updateRegistrationId(String... params) {
        inicializaRestTemplate().put(Constantes.URL_USUARIO_ATUALIZA_REG_ID, Usuario.class, params);
    }

    public Usuario get(Usuario... params) {
        return inicializaRestTemplate().getForObject(Constantes.URL_USUARIO_ID, Usuario.class, params[0].getId());
    }

    public void removeRegistrationId(String... params) {
        inicializaRestTemplate().put(Constantes.URL_USUARIO_ID, Usuario.class, params);
    }
}
