package tcc.aplicativo.pojos;

import java.sql.Date;
import java.util.Collection;


public class Usuario implements Entidade {


    private Long ID;

    private String nome;

    private String sobrenome;

    private char sexo;

    private int idade;

    private String senha;

    private String login;

    private Date dataNascimento;


    private Endereco endereco;


    private Collection<Evento> evento;

    private Collection<Doacao> doacao;


    private Collection<Comentario> comentario;


    private TipoSanguineo tipo;

    public Usuario() {
        super();
    }

    public Usuario(String nome, String sobrenome, char sexo, int idade,
                   String senha, String login) {
        super();
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        this.idade = idade;
        this.senha = senha;
        this.login = login;
    }

    public Usuario(String nome, String sobrenome, char sexo, int idade,
                   String senha, String login, Date dataNascimento, Endereco endereco,
                   Collection<Evento> evento, Collection<Doacao> doacao,
                   Collection<Comentario> comentario, TipoSanguineo tipo) {
        super();
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        this.idade = idade;
        this.senha = senha;
        this.login = login;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.evento = evento;
        this.doacao = doacao;
        this.comentario = comentario;
        this.tipo = tipo;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long iDUsuario) {
        this.ID = iDUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public String getLogin() {
        return login;
    }
}
