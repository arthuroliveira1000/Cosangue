package entitys;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Usuario {

	@Id
	@GeneratedValue
	@Column(name = "id_usuario")
	private Long ID;
	@Column(nullable = true)
	private String Nome;
	@Column(nullable = true)
	private String Sobrenome;
	@Column(nullable = true)
	private char Sexo;
	@Column(nullable = true)
	private int Idade;
	private String Senha;
	private String Login;
	private Date DataNascimento;

	@OneToOne(mappedBy = "usuario")
	private Endereco endereco;

	@OneToMany(mappedBy = "usuario")
	private Collection<Evento> evento;

	@OneToMany(mappedBy = "usuario")
	private Collection<Doacao> doacao;

	@OneToMany(mappedBy = "usuario")
	private Collection<Comentario> comentario;

	@ManyToOne
	@JoinColumn(name = "id_tipo")
	private TipoSanguineo tipo;

	public Long getID() {
		return ID;
	}

	public void setID(Long iDUsuario) {
		ID = iDUsuario;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public char getSexo() {
		return Sexo;
	}

	public void setSexo(char sexo) {
		Sexo = sexo;
	}

	public int getIdade() {
		return Idade;
	}

	public void setIdade(int idade) {
		Idade = idade;
	}

	public Date getDataNascimento() {
		return DataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		DataNascimento = dataNascimento;
	}

	public String getSobrenome() {
		return Sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		Sobrenome = sobrenome;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getSenha() {
		return Senha;
	}

	public String getLogin() {
		return Login;
	}

}
