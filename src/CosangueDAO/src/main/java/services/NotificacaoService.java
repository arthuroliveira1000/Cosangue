package services;

import java.util.List;

import managers.SimpleEntityManager;
import daos.NotificacaoDAO;
import entities.Notificacao;

public class NotificacaoService {

	private SimpleEntityManager simpleEntityManager = new SimpleEntityManager();
	private NotificacaoDAO dao = new NotificacaoDAO(
			simpleEntityManager.getEntityManager());

	public void save(Notificacao notificacao) {
		try {
			simpleEntityManager.beginTransaction();
			// FAZER VALIDAÇÃO DE CAMPOS NULOS, ETC
			dao.save(notificacao);
			simpleEntityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}

	public void delete(Notificacao notificacao) {
		try {
			simpleEntityManager.beginTransaction();
			dao.delete(notificacao);
			simpleEntityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}

	public void update(Notificacao notificacao) {
		try {
			simpleEntityManager.beginTransaction();
			dao.update(notificacao);
			simpleEntityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}

	public Notificacao selectById(Long id) {
		return dao.getById(id);
	}

	public List<Notificacao> findAll() {
		return dao.findAll(); // VERIFICAR SE NÃO RETORNA ERRO CASO LISTA FOR
								// VAZIA
	}

}
