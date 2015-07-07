package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Endereco implements Entidade {

	@Id
	@GeneratedValue
	@Column(name = "id_endereco")
	private Long ID;
	@Column(name = "logradouro")
	private String logradouro;
	@Column(name = "bairro")
	private String bairro;
	@Column(name = "numero")
	private int numero;
	@Column(name = "cidade")
	private String cidade;
	@Column(name = "UF")
	private String UF;
	@Column(name = "latitude")
	private String latitude;
	@Column(name = "longitude")
	private String longitude;

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_hemocentro")
	private Hemocentro hemocentro;

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_evento")
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
	//ENDEREÇO DE HEMOCENTRO
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
	
	// ENDEREÇO DE EVENTO
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
