package pojos;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	private String Nome;
	private String Tipo;
	private String Descricao;
	private Date Data;
	private Time Horario;
	private int Confirmados;
	private int Reportacoes;

	@OneToOne(mappedBy = "evento")
	private Endereco endereco;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@OneToMany(mappedBy = "evento")
	private Collection<Comentario> comentario;

	@OneToMany(mappedBy = "evento")
	private Collection<Notificacao> notificacao;

	@ManyToOne
	@JoinColumn(name = "id_hemocentro")
	private Hemocentro hemocentro;

	public Long getID() {
		return ID;
	}

	public void setID(Long iDEvento) {
		ID = iDEvento;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public int getConfirmados() {
		return Confirmados;
	}

	public void setConfirmados(int confirmados) {
		Confirmados = confirmados;
	}

	public int getReportacoes() {
		return Reportacoes;
	}

	public void setReportacoes(int reportacoes) {
		Reportacoes = reportacoes;
	}

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}

	public Time getHorario() {
		return Horario;
	}

	public void setHorario(Time horario) {
		Horario = horario;
	}

}
