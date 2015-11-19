package tcc.cosangueapp.daos;


import tcc.cosangueapp.pojos.Endereco;
import tcc.cosangueapp.pojos.Usuario;
import tcc.cosangueapp.utils.Constantes;

public class EnderecoDAO extends SimpleRestTemplate {


    public Endereco post(Object... params) {
        return inicializaRestTemplate().postForObject(Constantes.URL_ENDERECO, params[2], Endereco.class);
    }

    public void atualizaEndereco(String... params) {
        inicializaRestTemplate().put(Constantes.URL_ATUALIZA_ENDERECO, Endereco.class, params);
    }

  /*  public Acao get(Acao... params) {
        return inicializaRestTemplate().getForObject(Constantes.URL_ACAO_ID, Acao.class, params[0].getId());
    }

    public List<Acao> getAll() {
        Acao[] listaAcoes = inicializaRestTemplate().getForObject(Constantes.URL_ACAO, Acao[].class);
        return Arrays.asList(listaAcoes);
        //return Arrays.asList(restTemplate.getForObject(Constantes.URL_ACAO, Acao[].class));
    }*/
}
