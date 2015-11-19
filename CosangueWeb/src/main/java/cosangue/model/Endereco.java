package cosangue.model;


public class Endereco {

	private Long id;
	private String enderecoCompleto;
	private String logradouro;
	private String bairro;
	private int nr;
	private String cidade;
	private String uf;
	private String latitude;
	private String longitude;
	private Hemocentro hemocentro;
	private Acao acao;

	public Endereco() {
		super();
	}

	public Endereco(Long id, String enderecoCompleto, String logradouro, String bairro, int nr,
			String cidade, String uf, String latitude, String longitude,
			Hemocentro hemocentro, Acao acao) {
		super();
		this.id = id;
		this.enderecoCompleto = enderecoCompleto;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.nr = nr;
		this.cidade = cidade;
		this.uf = uf;
		this.latitude = latitude;
		this.longitude = longitude;
		this.hemocentro = hemocentro;
		this.acao = acao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Hemocentro getHemocentro() {
		return hemocentro;
	}

	public void setHemocentro(Hemocentro hemocentro) {
		this.hemocentro = hemocentro;
	}

	public Acao getAcao() {
		return acao;
	}

	public void setAcao(Acao acao) {
		this.acao = acao;
	}
	
	public String getEnderecoCompleto() {
		return enderecoCompleto;
	}

	public void setEnderecoCompleto(String enderecoCompleto) {
		this.enderecoCompleto = enderecoCompleto;
	}


}
