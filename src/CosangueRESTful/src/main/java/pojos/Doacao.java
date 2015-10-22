package pojos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Doacao implements Serializable {

	private static final long serialVersionUID = 5429710953608386278L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_doacao")
	private Long id;
	@Column(length = 10)
	private int quantidadeDoacao;
	private String dataDoacao;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public Doacao() {
		super();
	}

	public Doacao(Long id, int quantidadeDoacao, String dataDoacao,
			Usuario usuario) {
		super();
		this.id = id;
		this.quantidadeDoacao = quantidadeDoacao;
		this.dataDoacao = dataDoacao;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantidadeDoacao() {
		return quantidadeDoacao;
	}

	public void setQuantidadeDoacao(int quantidadeDoacao) {
		this.quantidadeDoacao = quantidadeDoacao;
	}

	public String getDataDoacao() {
		return dataDoacao;
	}
	//yyyy-MM-dd
	public void setDataDoacao(String dataDoacao) {
		this.dataDoacao = dataDoacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
