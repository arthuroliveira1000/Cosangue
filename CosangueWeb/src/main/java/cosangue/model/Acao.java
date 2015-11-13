package cosangue.model;

public class Acao  {
	
	private Long id;
	private String nome;
	private String descricao;
	private String dataHorario;
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

	public Acao(Long id, String nome, String descricao, String dataHorario,
			int nParticipantes, int nReportacoes, Categoria categoria,
			TipoSanguineo tipo, Endereco endereco, Hemocentro hemocentro,
			Hemocomponentes hemocomponente) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataHorario = dataHorario;
		this.nParticipantes = nParticipantes;
		this.nReportacoes = nReportacoes;
		this.categoria = categoria;
		this.tipo = tipo;
		this.endereco = endereco;
		this.hemocentro = hemocentro;
		this.hemocomponente = hemocomponente;
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

	public String getDataHorario() {
		return dataHorario;
	}

	// //"05/09/2013 06:30:07"
	public void setDataHorario(String dataHorario) {
		this.dataHorario = dataHorario;
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

}
