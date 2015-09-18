package tcc.aplicativo.pojos;

import java.util.Collection;


public class Hemocentro implements Entidade {


    private Long ID;

    private String nome;

    private String telefone;

    private String login;

    private String senha;


    private Endereco endereco;


    private Collection<Evento> evento;

    public Hemocentro() {
        super();
    }

    public Hemocentro(String nome, String telefone, String login,
                      String senha, Endereco endereco, Collection<Evento> evento) {
        super();
        this.nome = nome;
        this.telefone = telefone;
        this.login = login;
        this.senha = senha;
        this.endereco = endereco;
        this.evento = evento;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long iDHemocentro) {
        this.ID = iDHemocentro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
