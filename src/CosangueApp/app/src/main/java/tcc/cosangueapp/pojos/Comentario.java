package tcc.cosangueapp.pojos;

import java.io.Serializable;

public class Comentario implements Serializable {

    private Long id;
    private String mensagem;
    private Usuario usuario;
    private Acao acao;

    public Comentario() {
        super();
    }

    public Comentario(Long id, String mensagem, Usuario usuario, Acao acao) {
        super();
        this.id = id;
        this.mensagem = mensagem;
        this.usuario = usuario;
        this.acao = acao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Acao getAcao() {
        return acao;
    }

    public void setAcao(Acao acao) {
        this.acao = acao;
    }
}
