package pojos;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class TipoSanguineo implements Entidade {

	@Id
	@GeneratedValue
	@Column(name = "id_tipo")
	private Long ID;
	private String Descricao;

	@ManyToMany
	@JoinTable(name = "notificacao_tipoSanguineo", joinColumns = @JoinColumn(name = "id_tipo"), inverseJoinColumns = @JoinColumn(name = "id_notificacao"))
	private Collection<Notificacao> notificacao;

	public Long getID() {
		return ID;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public void setID(Long iDTipoSanguineo) {
		ID = iDTipoSanguineo;
	}

}
