package pojos;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

import org.json.JSONObject;

@XmlRootElement
@Entity
public class Usuario implements Entidade {

	@Id
	@GeneratedValue
	@Column(name = "id_usuario")
	private Long ID;
	@Column(name = "nome")
	private String nome;
	@Column(name = "sexo")
	private String sexo;
	@Column(name = "idade")
	private int idade;
	@Column(name = "senha")
	private String senha;
	@Column(name = "login")
	private String login;

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

	/*
	 * public Usuario(String nome, String sobrenome, String sexo, int idade,
	 * String login, String senha) { super(); this.nome = nome; this.sobrenome =
	 * sobrenome; this.sexo = sexo; this.idade = idade; this.login = login;
	 * this.senha = senha; }
	 */

	public Usuario(String nome) {
		super();
		this.nome = nome;
	}

	public Usuario(Long iD, String nome, String sexo, int idade, String senha,
			String login, Endereco endereco, Collection<Evento> evento,
			Collection<Doacao> doacao, Collection<Comentario> comentario,
			TipoSanguineo tipo) {
		super();
		ID = iD;
		this.nome = nome;
		this.sexo = sexo;
		this.idade = idade;
		this.senha = senha;
		this.login = login;
		this.endereco = endereco;
		this.evento = evento;
		this.doacao = doacao;
		this.comentario = comentario;
		this.tipo = tipo;
	}

	public Usuario(Long ID) {
		super();
		this.ID = ID;
	}

	public Usuario(String nome, String sexo, int idade, String senha,
			String login, Date dataNascimento, Endereco endereco,
			Collection<Evento> evento, Collection<Doacao> doacao,
			Collection<Comentario> comentario, TipoSanguineo tipo) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.idade = idade;
		this.senha = senha;
		this.login = login;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
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

	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public Usuario fromJSON(JSONObject json) {
		if (json.has("ID"))
			this.ID = json.getLong("ID");
		if (json.has("nome"))
			this.nome = json.getString("nome");
		if (json.has("sexo"))
			this.sexo = json.getString("sexo");
		if (json.has("login"))
			this.login = json.getString("login");
		if (json.has("senha"))
			this.senha = json.getString("senha");
		return this;
	}
}
