package entitys;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Notificacao {

	@Id
	@GeneratedValue
	@Column(name="id_notificacao")
	private Long IDNotificacao;
	private String Nome;
	private String Descricao;
	private String Tipo;
	
	@ManyToOne
	@JoinColumn(name="id_evento")
	private Evento evento;
	
	@ManyToMany
	@JoinTable(name="notificacao_tipoSanguineo", joinColumns=@JoinColumn(name="id_notificacao"),
	inverseJoinColumns=@JoinColumn(name="id_tipo"))
	private Collection<TipoSanguineo> tipoSanguineo;
	
	public Long getIDNotificacao() {
		return IDNotificacao;
	}

	public void setIDNotificacao(Long iDNotificacao) {
		IDNotificacao = iDNotificacao;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

}
