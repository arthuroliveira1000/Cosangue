package entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Doacao implements Serializable {

	private static final long serialVersionUID = 5429710953608386278L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_doacao")
	private Long id;
	@Column(length = 10)
	private int quantidadeDoacao;
	private Date dataDoacao;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public Doacao() {
		super();
	}

	public Doacao(Long id, int quantidadeDoacao, Date dataDoacao,
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

	public Date getDataDoacao() {
		return dataDoacao;
	}

	public void setDataDoacao(Date dataDoacao) {
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
