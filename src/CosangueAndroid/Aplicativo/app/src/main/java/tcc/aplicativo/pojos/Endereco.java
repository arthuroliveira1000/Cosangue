package tcc.aplicativo.pojos;

public class Endereco implements Entidade {


	private Long ID;

	private String logradouro;

	private String bairro;

	private int numero;

	private String cidade;

	private String UF;

	private String latitude;

	private String longitude;


	private Usuario usuario;


	private Hemocentro hemocentro;


	private Evento evento;

	public Endereco() {
		super();
	}
	
	//ENDERECO DE USUARIO
	public Endereco(String logradouro, String bairro, int numero,
			String cidade, String uF, String latitude, String longitude,
			Usuario usuario) {
		super();
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.numero = numero;
		this.cidade = cidade;
		this.UF = uF;
		this.latitude = latitude;
		this.longitude = longitude;
		this.usuario = usuario;
	}
	//ENDERE�O DE HEMOCENTRO
	public Endereco(String logradouro, String bairro, int numero,
			String cidade, String uF, String latitude, String longitude,
			Hemocentro hemocentro) {
		super();
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.numero = numero;
		this.cidade = cidade;
		this.UF = uF;
		this.latitude = latitude;
		this.longitude = longitude;
		this.hemocentro = hemocentro;
	}
	
	// ENDERE�O DE EVENTO
	public Endereco(String logradouro, String bairro, int numero,
			String cidade, String uF, String latitude, String longitude,
			Evento evento) {
		super();
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.numero = numero;
		this.cidade = cidade;
		this.UF = uF;
		this.latitude = latitude;
		this.longitude = longitude;
		this.evento = evento;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iDEndereco) {
		this.ID = iDEndereco;
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		this.UF = uF;
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

}
