package cosangue.model;


public class Acao {

	private Long id;
	private String nome;
	private String descricao;
	private String data;
	private String horario;
	private int nParticipantes;
	private int nReportacoes;
	private Categoria categoria;
	private TipoSanguineo tipo;
	private Hemocomponentes hemocomponente;

	private Endereco endereco;
	private Hemocentro hemocentro;

	public Acao() {
		super();
	}

	public Acao(Long id, String nome, String descricao, String data,
			int nParticipantes, int nReportacoes, Categoria categoria,
			TipoSanguineo tipo, Endereco endereco, Hemocentro hemocentro,
			Hemocomponentes hemocomponente, String horario) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.data = data;
		this.nParticipantes = nParticipantes;
		this.nReportacoes = nReportacoes;
		this.categoria = categoria;
		this.tipo = tipo;
		this.endereco = endereco;
		this.hemocentro = hemocentro;
		this.hemocomponente = hemocomponente;
		this.horario = horario;
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
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

	public TipoSanguineo getTipo() {
		return tipo;
	}

	public void setTipo(TipoSanguineo tipo) {
		this.tipo = tipo;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Hemocentro getHemocentro() {
		return hemocentro;
	}

	public void setHemocentro(Hemocentro hemocentro) {
		this.hemocentro = hemocentro;
	}

	public Hemocomponentes getHemocomponente() {
		return hemocomponente;
	}

	public void setHemocomponente(Hemocomponentes hemocomponente) {
		this.hemocomponente = hemocomponente;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

}
