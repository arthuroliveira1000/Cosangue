package entitys;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program {

	private static EntityManagerFactory factory;

	public static void main(String[] args) {

		factory = Persistence.createEntityManagerFactory("jpa-example");

		Program p = new Program();
		p.addUsuario("Poliana", "Oliveira", 'M', 16, "buum",
				"arthuroliveira1000", null);
		Usuario usuarioCarregado = p.procuraUsuario(1L);
		System.out.println("Usuário Carregado = " + usuarioCarregado.getNome());

		p.addHemocentro("HEMORGS", "33333333", "hemocentro123", "hemo1233");
		Hemocentro hemocentroCarregado = p.procuraHemocentro(1L);
		System.out.println("Hemocentro Carregado = "
				+ hemocentroCarregado.getNome());

		p.addEndereco("Ida Schuch", "VM", 333, "Sao leo", "RS", "33", "555");
		Endereco enderecoCarregado = p.procuraEndereco(1L);
		System.out.println("Endereco Carregado = "
				+ enderecoCarregado.getBairro());

		p.addComentario("Luana é legal, luana é sensacional");
		Comentario comentarioCarregado = p.procuraComentario(1L);
		System.out.println("Comentario Carregado = "
				+ comentarioCarregado.getMensagem());

		p.addDoacao(3, null);
		Doacao doacaoCarregado = p.procuraDoacao(1L);
		System.out.println("Doacao Carregado = "
				+ doacaoCarregado.getQuantidade());

		p.addEvento("Reposição", "Reposição", "fulano necessita de reposicao",
				134, 12, null, null);
		Evento eventoCarregado = p.procuraEvento(1L);
		System.out.println("Evento Carregado = " + eventoCarregado.getNome());

		p.addNotificacao("Urgente", "HEMORGS necessita de doacoes",
				"solicitacao");
		Notificacao notificacaoCarregada = p.procuraNotificacao(1L);
		System.out.println("Notificacao Carregado = "
				+ notificacaoCarregada.getNome());

		p.addTipoSanguineo("AB-");
		TipoSanguineo tipoSanguineoCarregado = p.procuraTipo(1L);
		System.out.println("Tipo Sanguineo Carregado = "
				+ tipoSanguineoCarregado.getDescricao());

		factory.close();
	}

	private Usuario procuraUsuario(Long id) {

		EntityManager manager = factory.createEntityManager();

		Usuario arthur = manager.find(Usuario.class, id);

		manager.close();

		return arthur;
	}

	private void addUsuario(String nome, String sobrenome, char sexo,
			int idade, String senha, String login, Date datanascimento) {
		Usuario arthur = new Usuario();
		arthur.setNome(nome);
		arthur.setSobrenome(sobrenome);
		arthur.setSexo(sexo);
		arthur.setIdade(idade);
		arthur.setSenha(senha);
		arthur.setLogin(login);
		arthur.setDataNascimento(datanascimento);

		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(arthur);
		manager.getTransaction().commit();

		System.out.println("ID do usuário = " + arthur.getIDUsuario());

		manager.close();
	}

	private void addHemocentro(String nome, String telefone, String login,
			String senha) {
		Hemocentro hemocentro = new Hemocentro();
		hemocentro.setNome(nome);
		hemocentro.setTelefone(telefone);
		hemocentro.setLogin(login);
		hemocentro.setSenha(senha);

		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(hemocentro);
		manager.getTransaction().commit();

		System.out
				.println("ID do hemocentro = " + hemocentro.getIDHemocentro());

		manager.close();
	}

	private Hemocentro procuraHemocentro(Long id) {

		EntityManager manager = factory.createEntityManager();

		Hemocentro hemocentro = manager.find(Hemocentro.class, id);

		manager.close();

		return hemocentro;
	}

	private void addEndereco(String logradouro, String bairro, int numero,
			String cidade, String UF, String latitude, String longitude) {
		Endereco endereco = new Endereco();
		endereco.setLogradouro(logradouro);
		endereco.setBairro(bairro);
		endereco.setNumero(numero);
		endereco.setCidade(cidade);
		endereco.setUF(UF);
		endereco.setLatitude(latitude);
		endereco.setLongitude(longitude);

		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(endereco);
		manager.getTransaction().commit();

		System.out.println("ID do hemocentro = " + endereco.getIDEndereco());

		manager.close();
	}

	private Endereco procuraEndereco(Long id) {

		EntityManager manager = factory.createEntityManager();

		Endereco endereco = manager.find(Endereco.class, id);

		manager.close();

		return endereco;
	}

	private void addComentario(String mensagem) {
		Comentario comentario = new Comentario();
		comentario.setMensagem(mensagem);

		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(comentario);
		manager.getTransaction().commit();

		System.out
				.println("ID do comentario = " + comentario.getIDComentario());

		manager.close();
	}

	private Comentario procuraComentario(Long id) {

		EntityManager manager = factory.createEntityManager();

		Comentario comentario = manager.find(Comentario.class, id);

		manager.close();

		return comentario;
	}

	private void addDoacao(int quantidade, Date data) {
		Doacao doacao = new Doacao();
		doacao.setQuantidade(quantidade);
		doacao.setData(data);

		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(doacao);
		manager.getTransaction().commit();

		System.out.println("ID do doacao = " + doacao.getIDDoacao());

		manager.close();
	}

	private Doacao procuraDoacao(Long id) {

		EntityManager manager = factory.createEntityManager();

		Doacao doacao = manager.find(Doacao.class, id);

		manager.close();

		return doacao;
	}

	private void addEvento(String nome, String tipo, String descricao,
			int confirmados, int reportacoes, Date data, Time horario) {
		Evento evento = new Evento();
		evento.setNome(nome);
		evento.setTipo(tipo);
		evento.setDescricao(descricao);
		evento.setConfirmados(confirmados);
		evento.setReportacoes(reportacoes);
		evento.setData(data);
		evento.setHorario(horario);

		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(evento);
		manager.getTransaction().commit();

		System.out.println("ID do evento = " + evento.getIDEvento());

		manager.close();
	}

	private Evento procuraEvento(Long id) {

		EntityManager manager = factory.createEntityManager();

		Evento evento = manager.find(Evento.class, id);

		manager.close();

		return evento;
	}

	private void addNotificacao(String nome, String descricao, String tipo) {
		Notificacao notificacao = new Notificacao();
		notificacao.setNome(nome);
		notificacao.setDescricao(descricao);
		notificacao.setTipo(tipo);

		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(notificacao);
		manager.getTransaction().commit();

		System.out.println("ID da notificacao = "
				+ notificacao.getIDNotificacao());

		manager.close();
	}

	private Notificacao procuraNotificacao(Long id) {

		EntityManager manager = factory.createEntityManager();

		Notificacao notificacao = manager.find(Notificacao.class, id);

		manager.close();

		return notificacao;
	}

	private void addTipoSanguineo(String descricao) {
		TipoSanguineo tipoSanguineo = new TipoSanguineo();
		tipoSanguineo.setDescricao(descricao);

		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(tipoSanguineo);
		manager.getTransaction().commit();

		System.out.println("ID da tipo sanguineo = "
				+ tipoSanguineo.getIDTipoSanguineo());

		manager.close();
	}

	private TipoSanguineo procuraTipo(Long id) {

		EntityManager manager = factory.createEntityManager();

		TipoSanguineo tipoSanguineo = manager.find(TipoSanguineo.class, id);

		manager.close();

		return tipoSanguineo;
	}
}
