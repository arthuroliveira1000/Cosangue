package pojos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@XmlRootElement
@Entity
public class Acao implements Serializable {

	private static final long serialVersionUID = 775455337770883259L;

	@Id
	@GeneratedValue
	@Column(name = "id_acao")
	private Long id;
	@Column(length = 200)
	private String nome;
	@Column(length = 600)
	private String descricao;
	private String data;
	private String horario;
	@Column(length = 1000)
	private int nParticipantes;
	@Column(length = 1000)
	private int nReportacoes;
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	@Enumerated(EnumType.STRING)
	private TipoSanguineo tipo;
	@Enumerated(EnumType.STRING)
	private Hemocomponentes hemocomponente;

	@OneToOne(mappedBy = "acao", fetch = FetchType.EAGER)
	@Cascade(value = CascadeType.DELETE)
	//@OneToOne(mappedBy = "acao", optional = true, fetch = FetchType.LAZY)
	private Endereco endereco;

	@LazyCollection(LazyCollectionOption.FALSE)
	// @ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	
	@LazyCollection(LazyCollectionOption.FALSE)
	 @OneToMany(mappedBy = "acao", targetEntity = Comentario.class)
	//@OneToMany(mappedBy = "acao", fetch = FetchType.LAZY)
	private List<Comentario> comentario;

	@LazyCollection(LazyCollectionOption.FALSE)
	// @ManyToOne(optional = true, fetch = FetchType.LAZY)
	@ManyToOne(optional = true)
	@JoinColumn(name = "id_hemocentro")
	private Hemocentro hemocentro;

	public Acao() {
		super();
	}

	public Acao(Long id, String nome, String descricao, String data,
			int nParticipantes, int nReportacoes, Categoria categoria,
			TipoSanguineo tipo, Endereco endereco, Usuario usuario,
			List<Comentario> comentario, Hemocentro hemocentro,
			Hemocomponentes hemocomponente, String horario) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.data = data;
		this.nParticipantes = nParticipantes;
		this.nReportacoes = nReportacoes;
		this.categoria = categoria;
		this.tipo = tipo;
		this.endereco = endereco;
		this.usuario = usuario;
		this.comentario = comentario;
		this.hemocentro = hemocentro;
		this.hemocomponente = hemocomponente;
		this.horario = horario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getnParticipantes() {
		return nParticipantes;
	}

	public void setnParticipantes(int nParticipantes) {
		this.nParticipantes = nParticipantes;
	}

	public int getnReportacoes() {
		return nReportacoes;
	}

	public void setnReportacoes(int nReportacoes) {
		this.nReportacoes = nReportacoes;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public TipoSanguineo getTipo() {
		return tipo;
	}

	public void setTipo(TipoSanguineo tipo) {
		this.tipo = tipo;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Hemocentro getHemocentro() {
		return hemocentro;
	}

	public void setHemocentro(Hemocentro hemocentro) {
		this.hemocentro = hemocentro;
	}

	public List<Comentario> getComentario() {
		return comentario;
	}

	public void setComentario(List<Comentario> comentario) {
		this.comentario = comentario;
	}

	public Hemocomponentes getHemocomponente() {
		return hemocomponente;
	}

	public void setHemocomponente(Hemocomponentes hemocomponente) {
		this.hemocomponente = hemocomponente;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
