package tcc.aplicativo.pojos;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;


public class Evento implements Entidade {


	private Long ID;

	private String nome;

	private String tipo;

	private String descricao;

	private Date data;

	private Time horario;

	private int confirmados;

	private int reportacoes;


	private Endereco endereco;


	private Usuario usuario;


	private Collection<Comentario> comentario;

	private Collection<Notificacao> notificacao;

	 Hemocentro hemocentro;

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
