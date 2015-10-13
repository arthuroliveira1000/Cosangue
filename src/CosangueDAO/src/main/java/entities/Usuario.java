package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 5286418095498767539L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;
	@Column(length = 200)
	private String nome;
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	@Column(length = 1)
	private char genero;
	@Column(length = 30)
	private String senha;
	@Column(length = 30)
	private String login;
	@Enumerated
	private Sangue tipoSanguineo;

	@OneToOne(mappedBy = "usuario", fetch = FetchType.LAZY)
	private Endereco endereco;

	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private Collection<Acao> acao;

	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private Collection<Doacao> doacao;

	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private Collection<Comentario> comentario;

	public Usuario() {
		super();
	}

	public Usuario(Long id, String nome, Date dataNascimento, char genero,
			String senha, String login, Sangue tipoSanguineo,
			Endereco endereco, Collection<Acao> acao,
			Collection<Doacao> doacao, Collection<Comentario> comentario) {
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Sangue getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(Sangue tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Collection<Acao> getAcao() {
		return acao;
	}

	public void setAcao(Collection<Acao> acao) {
		this.acao = acao;
	}

	public Collection<Doacao> getDoacao() {
		return doacao;
	}

	public void setDoacao(Collection<Doacao> doacao) {
		this.doacao = doacao;
	}

	public Collection<Comentario> getComentario() {
		return comentario;
	}

	public void setComentario(Collection<Comentario> comentario) {
		this.comentario = comentario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
