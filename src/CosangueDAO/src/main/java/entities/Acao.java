package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Acao implements Serializable {

	private static final long serialVersionUID = 775455337770883259L;
	
	@Id
	@GeneratedValue
	@Column(name = "id_acao")
	private Long id;
	@Column(length = 200)
	private String nome;
	@Column(length = 600)
	private String descricao;
	@Temporal(TemporalType.DATE)
	private Date dataHorario;
	@Column(length = 1000)
	private int nParticipantes;
	@Column(length = 1000)
	private int nReportacoes;
	@Enumerated
	private Categoria categoria;
	@Enumerated
	private Sangue tipo;

	@OneToOne(mappedBy = "acao", fetch = FetchType.LAZY, optional = true)
	private Endereco endereco;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@OneToMany(mappedBy = "acao", fetch = FetchType.LAZY)
	private Collection<Comentario> comentario;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_hemocentro")
	private Hemocentro hemocentro;

	public Acao() {
		super();
	}

	public Acao(Long id, String nome, String descricao, Date dataHorario,
			int nParticipantes, int nReportacoes, Categoria categoria,
			Sangue tipo, Endereco endereco, Usuario usuario,
			Collection<Comentario> comentario, Hemocentro hemocentro) {
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

	public Date getDataHorario() {
		return dataHorario;
	}

	public void setDataHorario(Date dataHorario) {
		this.dataHorario = dataHorario;
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

	public Sangue getTipo() {
		return tipo;
	}

	public void setTipo(Sangue tipo) {
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

	public Collection<Comentario> getComentario() {
		return comentario;
	}

	public void setComentario(Collection<Comentario> comentario) {
		this.comentario = comentario;
	}

	public Hemocentro getHemocentro() {
		return hemocentro;
	}

	public void setHemocentro(Hemocentro hemocentro) {
		this.hemocentro = hemocentro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
