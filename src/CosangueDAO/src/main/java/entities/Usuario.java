package entities;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Usuario implements Entidade {

	@Id
	@GeneratedValue
	@Column(name = "id_usuario")
	private Long ID;
	@Column(name = "nome")
	private String nome;
	@Column(name = "sobrenome", nullable = true)
	private String sobrenome;
	@Column(name = "sexo")
	private char sexo;
	@Column(name = "idade")
	private int idade;
	@Column(name = "senha")
	private String senha;
	@Column(name = "login")
	private String login;
	@Column(name = "dataNascimento")
	private Date dataNascimento;

	@OneToOne(mappedBy = "usuario", fetch = FetchType.LAZY)
	private Endereco endereco;

	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private Collection<Evento> evento;

	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private Collection<Doacao> doacao;

	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private Collection<Comentario> comentario;

	@ManyToOne
	@JoinColumn(name = "id_tipo")
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
