package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Comentario implements Entidade {

	@Id
	@GeneratedValue
	@Column(name = "id_comentario")
	private Long ID;
	@Column(name = "mensagem")
	private String mensagem;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_evento")
	private Evento evento;

	public Comentario() {
		super();
	}

	public Comentario(String mensagem, Usuario usuario, Evento evento) {
		super();
		this.mensagem = mensagem;
		this.usuario = usuario;
		this.evento = evento;
	}

	public Comentario(String mensagem) {
		this.mensagem = mensagem;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		this.ID = iD;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}
