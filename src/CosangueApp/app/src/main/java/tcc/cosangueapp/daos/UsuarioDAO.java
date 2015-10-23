package tcc.cosangueapp.daos;

import tcc.cosangueapp.utils.Constantes;
import tcc.cosangueapp.pojos.Usuario;

public class UsuarioDAO extends SimpleRestTemplate {

    public Usuario login(String... params) {
        return restTemplate.getForObject(Constantes.URL_LOGIN, Usuario.class, params);
    }

    public Usuario cadastro(Usuario... params) {
        return restTemplate.postForObject(Constantes.URL_CADASTRO, params[0], Usuario.class);
    }
}
