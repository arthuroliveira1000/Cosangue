package services;

import java.util.List;

import managers.SimpleEntityManager;
import daos.AcaoDAO;
import entities.Acao;

public class AcaoService {

	private SimpleEntityManager simpleEntityManager = new SimpleEntityManager();
	private AcaoDAO dao = new AcaoDAO(
			simpleEntityManager.getEntityManager());

	public void save(Acao evento) {
		try {
			simpleEntityManager.beginTransaction();
			// FAZER VALIDAÇÃO DE CAMPOS NULOS, ETC
			dao.save(evento);
			simpleEntityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}

	public void delete(Acao evento) {
		try {
			simpleEntityManager.beginTransaction();
			dao.delete(evento);
			simpleEntityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}

	public void update(Acao evento) {
		try {
			simpleEntityManager.beginTransaction();
			dao.update(evento);
			simpleEntityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}

	public Acao selectById(Long id) {
		return dao.getById(id);
	}

	public List<Acao> findAll() {
		return dao.findAll(); // VERIFICAR SE NÃO RETORNA ERRO CASO LISTA FOR
								// VAZIA
	}

}
