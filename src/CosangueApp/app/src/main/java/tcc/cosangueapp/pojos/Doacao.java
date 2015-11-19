package tcc.cosangueapp.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

import tcc.cosangueapp.utils.DateUtils;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Doacao implements Serializable {

    private Long id;
    private String dataDoacao;
    private Usuario usuario;

    public Doacao() {
        super();
    }

    public Doacao(Long id, String dataDoacao,
                  Usuario usuario) {
        super();
        this.id = id;
        this.dataDoacao = dataDoacao;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataDoacao() {
        return dataDoacao;
    }

    public void setDataDoacao(Date dataDoacao) {
        this.dataDoacao = DateUtils.dateTimeToString(dataDoacao);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
