package tcc.aplicativo.pojos;

public class Comentario implements Entidade {


    private Long ID;

    private String mensagem;

    private Usuario usuario;


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
