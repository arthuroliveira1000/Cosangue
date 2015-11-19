package pojos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
public class Hemocentro implements Serializable {

	private static final long serialVersionUID = -8117345146225594913L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_hemocentro")
	private Long id;
	@Column(length = 200)
	private String nome;
	@Column(length = 40)
	private String telefone;
	@Column(length = 30)
	private String login;
	@Column(length = 30)
	private String senha;
	@OneToOne(mappedBy = "hemocentro", fetch = FetchType.LAZY, optional = true)
	private Endereco endereco;

	@OneToMany(mappedBy = "hemocentro", fetch = FetchType.LAZY, targetEntity = Acao.class)
	private List<Acao> acao;

	public Hemocentro() {
		super();
	}

	public Hemocentro(Long id, String nome, String telefone, String login,
			String senha, Endereco endereco, List<Acao> acao) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.login = login;
		this.senha = senha;
		this.endereco = endereco;
		this.acao = acao;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
    
	@XmlTransient
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
