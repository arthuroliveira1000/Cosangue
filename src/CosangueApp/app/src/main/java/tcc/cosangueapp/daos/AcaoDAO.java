package tcc.cosangueapp.daos;


import java.util.Arrays;
import java.util.List;

import tcc.cosangueapp.pojos.Acao;
import tcc.cosangueapp.utils.Constantes;

public class AcaoDAO extends SimpleRestTemplate {


    public Acao post(Acao... params) {
        return inicializaRestTemplate().postForObject(Constantes.URL_ACAO, params[0], Acao.class);
    }

    public Acao get(Acao... params) {
        return inicializaRestTemplate().getForObject(Constantes.URL_ACAO_ID, Acao.class, params[0].getId());
    }

    public List<Acao> getAll() {
        Acao[] listaAcoes = inicializaRestTemplate().getForObject(Constantes.URL_ACAO, Acao[].class);
        return Arrays.asList(listaAcoes);
        //return Arrays.asList(restTemplate.getForObject(Constantes.URL_ACAO, Acao[].class));
    }
}
