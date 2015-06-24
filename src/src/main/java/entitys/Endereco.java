package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Endereco implements Entidade{

	@Id
	@GeneratedValue
	@Column(name="id_endereco")
	private Long ID;
	private String Logradouro;
	private String Bairro;
	private int Numero;
	private String Cidade;
	private String UF;
	private String Latitude;
	private String Longitude;
	
	@OneToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn(name="id_hemocentro")
	private Hemocentro hemocentro;
	
	@OneToOne
	@JoinColumn(name="id_evento")
	private Evento evento;

	public Long getID() {
		return ID;
	}

	public void setID(Long iDEndereco) {
		ID = iDEndereco;
	}

	public String getLogradouro() {
		return Logradouro;
	}

	public void setLogradouro(String logradouro) {
		Logradouro = logradouro;
	}

	public String getBairro() {
		return Bairro;
	}

	public void setBairro(String bairro) {
		Bairro = bairro;
	}

	public int getNumero() {
		return Numero;
	}

	public void setNumero(int numero) {
		Numero = numero;
	}

	public String getCidade() {
		return Cidade;
	}

	public void setCidade(String cidade) {
		Cidade = cidade;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

}
