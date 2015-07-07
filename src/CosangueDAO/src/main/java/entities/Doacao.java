package entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Doacao implements Entidade {

	@Id
	@GeneratedValue
	@Column(name = "id_doacao")
	private Long ID;
	@Column(name = "quantidade")
	private int quantidade;
	@Column(name = "data")
	private Date data;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public Doacao() {
		super();
	}

	public Doacao(int quantidade, Date data, Usuario usuario) {
		super();
		this.quantidade = quantidade;
		this.data = data;
		this.usuario = usuario;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iDDoacao) {
		this.ID = iDDoacao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
