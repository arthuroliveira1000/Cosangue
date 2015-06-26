package services;

import java.util.List;

import managers.SimpleEntityManager;
import daos.NotificacaoDAO;
import entities.Notificacao;

public class NotificacaoService {

	private NotificacaoDAO dao;
	private SimpleEntityManager simpleEntityManager;

	public NotificacaoService(SimpleEntityManager simpleEntityManager) {
		super();
		this.simpleEntityManager = simpleEntityManager;
		this.dao = new NotificacaoDAO(simpleEntityManager.getEntityManager());
	}

	public void save(Notificacao notificacao) {
		try {
			simpleEntityManager.beginTransaction();
			// FAZER VALIDA��O DE CAMPOS NULOS, ETC
			dao.save(notificacao);
			simpleEntityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}

	public List<Notificacao> findAll() {
		return dao.findAll(); // VERIFICAR SE N�O RETORNA ERRO CASO LISTA FOR
								// VAZIA
	}

}
