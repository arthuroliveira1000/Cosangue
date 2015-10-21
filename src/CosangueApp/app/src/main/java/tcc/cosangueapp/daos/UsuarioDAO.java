package tcc.cosangueapp.daos;

import tcc.cosangueapp.Utils.Constantes;
import tcc.cosangueapp.pojos.Usuario;

public class UsuarioDAO extends SimpleRestTemplate {

    public Usuario login(String... params) {
        return restTemplate.getForObject(Constantes.URL_USUARIO, Usuario.class, params);
    }

    public Usuario cadastro(Usuario... params) {
        return restTemplate.postForObject(Constantes.URL_USUARIO, params[0], Usuario.class);
    }
}
