package pojos;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Notificacao implements Entidade {

	@Id
	@GeneratedValue
	@Column(name = "id_notificacao")
	private Long ID;
	@Column(name = "nome")
	private String nome;
	@Column(name = "descricao")
	private String descricao;
	@Column(name = "tipo")
	private String tipo;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_evento")
	private Evento evento;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "notificacao_tipoSanguineo", joinColumns = @JoinColumn(name = "id_notificacao"), inverseJoinColumns = @JoinColumn(name = "id_tipo"))
	private Collection<TipoSanguineo> tipoSanguineo;

	public Notificacao() {
		super();
	}

	public Notificacao(String nome, String descricao, String tipo,
			Evento evento, Collection<TipoSanguineo> tipoSanguineo) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.tipo = tipo;
		this.evento = evento;
		this.tipoSanguineo = tipoSanguineo;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iDNotificacao) {
		this.ID = iDNotificacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
