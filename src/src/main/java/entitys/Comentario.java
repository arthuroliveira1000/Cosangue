package entitys;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Comentario {

	@Id
	@GeneratedValue
	@Column(name="id_comentario")
	private Long IDComentario;
	private String Mensagem;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="id_evento")
	private Evento evento; 
	
	
	public Long getIDComentario() {
		return IDComentario;
	}

	public void setIDComentario(Long iDComentario) {
		IDComentario = iDComentario;
	}

	public String getMensagem() {
		return Mensagem;
	}

	public void setMensagem(String mensagem) {
		Mensagem = mensagem;
	}
}
