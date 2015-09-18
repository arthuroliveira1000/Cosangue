package pojos;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Hemocentro implements Entidade {

	@Id
	@GeneratedValue
	@Column(name = "id_hemocentro")
	private Long ID;
	@Column(name = "nome")
	private String nome;
	@Column(name = "telefone")
	private String telefone;
	@Column(name = "login")
	private String login;
	@Column(name = "senha")
	private String senha;

	@OneToOne(mappedBy = "hemocentro", fetch = FetchType.LAZY, optional = true)
	private Endereco endereco;

	@OneToMany(mappedBy = "hemocentro", fetch = FetchType.LAZY)
	private Collection<Evento> evento;

	public Hemocentro() {
		super();
	}

	public Hemocentro(String nome, String telefone, String login, String senha,
			Endereco endereco, Collection<Evento> evento) {
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
