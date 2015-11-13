package cosangue.model;


public class Hemocentro {

	private Long id;
	private String nome;
	private String telefone;
	private String login;
	private String senha;
	private Endereco endereco;
	//private List<Acao> acao;

	public Hemocentro() {
		super();
	}

	public Hemocentro(Long id, String nome, String telefone, String login,
			String senha, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.login = login;
		this.senha = senha;
		this.endereco = endereco;
	//	this.acao = acao;
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
	
/*	public List<Acao> getAcao() {
		return acao;
	}

	public void setAcao(List<Acao> acao) {
		this.acao = acao;
	}*/
}
