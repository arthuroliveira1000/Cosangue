package tcc.cosangueapp.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import tcc.cosangueapp.utils.DateUtils;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Usuario implements Serializable {

    private Long id;
    private String nome;
    private String dataNascimento;
    private Genero genero;
    private String senha;
    private String login;
    private TipoSanguineo tipoSanguineo;
    private String registrationId;
    private int quantidadeDoacao;

    private Endereco endereco;

    private List<Acao> acao;

    private List<Doacao> doacao;

    private List<Comentario> comentario;

    public Usuario() {
        super();
    }

    public Usuario(Long id, String nome, String dataNascimento, Genero genero,
                   String senha, String login, TipoSanguineo tipoSanguineo,
                   Endereco endereco, List<Acao> acao, List<Doacao> doacao,
                   List<Comentario> comentario, String registrationId, int quantidadeDoacao) {
        super();
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.senha = senha;
        this.login = login;
        this.tipoSanguineo = tipoSanguineo;
        this.endereco = endereco;
        this.acao = acao;
        this.doacao = doacao;
        this.comentario = comentario;
        this.registrationId = registrationId;
        this.quantidadeDoacao = quantidadeDoacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getregistrationId() {
        return registrationId;
    }

    public void setregistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getQuantidadeDoacao() {
        return quantidadeDoacao;
    }

    public void setQuantidadeDoacao(int quantidade) {
        this.quantidadeDoacao = quantidade;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public TipoSanguineo getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Doacao> getDoacao() {
        return doacao;
    }

    public void setDoacao(List<Doacao> doacao) {
        this.doacao = doacao;
    }

    public List<Comentario> getComentario() {
        return comentario;
    }

    public void setComentario(List<Comentario> comentario) {
        this.comentario = comentario;
    }

    public List<Acao> getAcao() {
        return acao;
    }

    public void setAcao(List<Acao> acao) {
        this.acao = acao;
    }
}
