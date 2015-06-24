package pojos;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	private int Quantidade;
	private Date Data;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	
	public Long getID() {
		return ID;
	}

	public void setID(Long iDDoacao) {
		ID = iDDoacao;
	}

	public int getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}

}
