package tcc.cosangueapp.daos;


import tcc.cosangueapp.pojos.Acao;
import tcc.cosangueapp.utils.Constantes;

public class AcaoDAO extends SimpleRestTemplate {


    public Acao post(Object... params) {
        return inicializaRestTemplate().postForObject(Constantes.URL_ACAO, params[1], Acao.class);
    }

    public void put(String... params) {
        inicializaRestTemplate().put(Constantes.URL_ACAO_USUARIO, Acao.class, params);
    }
}
