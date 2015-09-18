package tcc.aplicativo.pojos;

import java.sql.Date;


public class Doacao implements Entidade {


    private Long ID;

    private int quantidade;

    private Date data;

    private Usuario usuario;

    public Doacao() {
        super();
    }

    public Doacao(int quantidade, Date data, Usuario usuario) {
        super();
        this.quantidade = quantidade;
        this.data = data;
        this.usuario = usuario;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long iDDoacao) {
        this.ID = iDDoacao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
