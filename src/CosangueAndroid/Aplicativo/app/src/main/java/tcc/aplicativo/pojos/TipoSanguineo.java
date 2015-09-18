package tcc.aplicativo.pojos;

import java.util.Collection;


public class TipoSanguineo implements Entidade {


    private Long ID;

    private String descricao;

    public TipoSanguineo() {
        super();
    }

    public TipoSanguineo(String descricao,
                         Collection<Notificacao> notificacao) {
        super();
        this.descricao = descricao;
        this.notificacao = notificacao;
    }


    private Collection<Notificacao> notificacao;

    public Long getID() {
        return ID;
    }

    public void setID(Long iDTipoSanguineo) {
        this.ID = iDTipoSanguineo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
