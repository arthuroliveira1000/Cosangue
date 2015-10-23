package tcc.cosangueapp.pojos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import tcc.cosangueapp.utils.DateUtils;


public class Acao implements Serializable {

    private Long id;
    private String nome;
    private String descricao;
    private String dataHorario;
    private int nParticipantes;
    private int nReportacoes;
    private Categoria categoria;
    private TipoSanguineo tipo;
    private Hemocomponentes hemocomponente;

    private Endereco endereco;

    private Usuario usuario;

    private List<Comentario> comentario;

    private Hemocentro hemocentro;

    public Acao() {
        super();
    }

    public Acao(Long id, String nome, String descricao, String dataHorario,
                int nParticipantes, int nReportacoes, Categoria categoria,
                TipoSanguineo tipo, Endereco endereco, Usuario usuario,
                List<Comentario> comentario, Hemocentro hemocentro, Hemocomponentes hemocomponente) {
        super();
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataHorario = dataHorario;
        this.nParticipantes = nParticipantes;
        this.nReportacoes = nReportacoes;
        this.categoria = categoria;
        this.tipo = tipo;
        this.endereco = endereco;
        this.usuario = usuario;
        this.comentario = comentario;
        this.hemocentro = hemocentro;
        this.hemocomponente = hemocomponente;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataHorario() {
        return dataHorario;
    }

    public void setDataHorario(Date dataHorario) {
        this.dataHorario = DateUtils.dateTimeToString(dataHorario);
    }

    public int getnParticipantes() {
        return nParticipantes;
    }

    public void setnParticipantes(int nParticipantes) {
        this.nParticipantes = nParticipantes;
    }

    public int getnReportacoes() {
        return nReportacoes;
    }

    public void setnReportacoes(int nReportacoes) {
        this.nReportacoes = nReportacoes;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public TipoSanguineo getTipo() {
        return tipo;
    }

    public void setTipo(TipoSanguineo tipo) {
        this.tipo = tipo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Hemocentro getHemocentro() {
        return hemocentro;
    }

    public void setHemocentro(Hemocentro hemocentro) {
        this.hemocentro = hemocentro;
    }

    public List<Comentario> getComentario() {
        return comentario;
    }

    public void setComentario(List<Comentario> comentario) {
        this.comentario = comentario;
    }

    public Hemocomponentes getHemocomponente() {
        return hemocomponente;
    }

    public void setHemocomponente(Hemocomponentes hemocomponente) {
        this.hemocomponente = hemocomponente;
    }
}
