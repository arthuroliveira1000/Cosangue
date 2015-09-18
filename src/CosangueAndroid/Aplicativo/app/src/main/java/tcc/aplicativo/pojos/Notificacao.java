package tcc.aplicativo.pojos;

import java.util.Collection;


public class Notificacao implements Entidade {


    private Long ID;

    private String nome;

    private String descricao;

    private String tipo;


    private Evento evento;


    private Collection<TipoSanguineo> tipoSanguineo;

    public Notificacao() {
        super();
    }

    public Notificacao(String nome, String descricao, String tipo,
                       Evento evento, Collection<TipoSanguineo> tipoSanguineo) {
        super();
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.evento = evento;
        this.tipoSanguineo = tipoSanguineo;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long iDNotificacao) {
        this.ID = iDNotificacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
