package entitys;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Hemocentro {

	@Id
	@GeneratedValue
	@Column(name="id_hemocentro")
	private Long IDHemocentro;
	private String Nome;
	private String Telefone;
	private String Login;
	private String Senha;
	
	@OneToOne(mappedBy="hemocentro")
	private Endereco endereco;
	
	@OneToMany(mappedBy="hemocentro")
	private Collection<Evento> evento;

	public Long getIDHemocentro() {
		return IDHemocentro;
	}

	public void setIDHemocentro(Long iDHemocentro) {
		IDHemocentro = iDHemocentro;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}

}
