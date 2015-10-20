package pojos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
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
	@Enumerated(EnumType.STRING)
	private Genero genero;
	@Column(length = 30)
	private String senha;
	@Column(length = 30)
	private String login;
	@Enumerated(EnumType.STRING)
	private Sangue tipoSanguineo;

	@OneToOne(mappedBy = "usuario", fetch = FetchType.EAGER)
	private Endereco endereco;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "usuario", targetEntity = Acao.class)
	private List<Acao> acao;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "usuario", targetEntity = Doacao.class)
	private List<Doacao> doacao;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "usuario", targetEntity = Comentario.class)
	private List<Comentario> comentario;

	public Usuario() {
		super();
	}

	public Usuario(Long id, String nome, Date dataNascimento, Genero genero,
			String senha, String login, Sangue tipoSanguineo,
			Endereco endereco, List<Acao> acao, List<Doacao> doacao,
			List<Comentario> comentario) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
