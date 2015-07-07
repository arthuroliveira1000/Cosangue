package entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@Column(name = "descricao")
	private String descricao;

	public TipoSanguineo() {
		super();
	}

	public TipoSanguineo(String descricao,
			Collection<Notificacao> notificacao) {
		super();
		this.descricao = descricao;
		this.notificacao = notificacao;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "notificacao_tipoSanguineo", joinColumns = @JoinColumn(name = "id_tipo"), inverseJoinColumns = @JoinColumn(name = "id_notificacao"))
	private Collection<Notificacao> notificacao;

	public Long getID() {
		return ID;
	}

	public void setID(Long iDTipoSanguineo) {
		this.ID = iDTipoSanguineo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
