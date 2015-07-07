package entities;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Evento implements Entidade {

	@Id
	@GeneratedValue
	@Column(name = "id_evento")
	private Long ID;
	@Column(name = "nome")
	private String nome;
	@Column(name = "tipo")
	private String tipo;
	@Column(name = "descricao")
	private String descricao;
	@Column(name = "data")
	private Date data;
	@Column(name = "horario")
	private Time horario;
	@Column(name = "confirmados")
	private int confirmados;
	@Column(name = "reportacoes")
	private int reportacoes;

	@OneToOne(mappedBy = "evento", fetch = FetchType.LAZY, optional = true)
	private Endereco endereco;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@OneToMany(mappedBy = "evento", fetch = FetchType.LAZY)
	private Collection<Comentario> comentario;

	@OneToMany(mappedBy = "evento", fetch = FetchType.LAZY)
	private Collection<Notificacao> notificacao;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_hemocentro")
	private Hemocentro hemocentro;

	public Evento() {
		super();
	}

	public Evento(String nome, String tipo, String descricao, Date data,
			Time horario, int confirmados, int reportacoes, Endereco endereco,
			Usuario usuario, Collection<Comentario> comentario,
			Collection<Notificacao> notificacao, Hemocentro hemocentro) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.descricao = descricao;
		this.data = data;
		this.horario = horario;
		this.confirmados = confirmados;
		this.reportacoes = reportacoes;
		this.endereco = endereco;
		this.usuario = usuario;
		this.comentario = comentario;
		this.notificacao = notificacao;
		this.hemocentro = hemocentro;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iDEvento) {
		ID = iDEvento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getConfirmados() {
		return confirmados;
	}

	public void setConfirmados(int confirmados) {
		this.confirmados = confirmados;
	}

	public int getReportacoes() {
		return reportacoes;
	}

	public void setReportacoes(int reportacoes) {
		this.reportacoes = reportacoes;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Time getHorario() {
		return horario;
	}

	public void setHorario(Time horario) {
		this.horario = horario;
	}

}
