package pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Endereco implements Serializable {

	private static final long serialVersionUID = -3468067506024353507L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Long id;
	@Column(length = 200)
	private String logradouro;
	@Column(length = 100)
	private String bairro;
	@Column(name = "numero")
	private int nr;
	@Column(length = 100)
	private String cidade;
	@Column(name = "UF", length = 2)
	private String uf;
	private String latitude;
	private String longitude;

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_hemocentro")
	private Hemocentro hemocentro;

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_acao")
	private Acao acao;

	public Endereco() {
		super();
	}

	public Endereco(Long id, String logradouro, String bairro, int nr,
			String cidade, String uf, String latitude, String longitude,
			Usuario usuario, Hemocentro hemocentro, Acao acao) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.nr = nr;
		this.cidade = cidade;
		this.uf = uf;
		this.latitude = latitude;
		this.longitude = longitude;
		this.usuario = usuario;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
