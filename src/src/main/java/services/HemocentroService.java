package services;

import java.util.List;

import managers.SimpleEntityManager;
import daos.HemocentroDAO;
import entities.Comentario;
import entities.Hemocentro;

public class HemocentroService {

	private HemocentroDAO dao;
	private SimpleEntityManager simpleEntityManager;

	public HemocentroService(SimpleEntityManager simpleEntityManager) {
		super();
		this.simpleEntityManager = simpleEntityManager;
		this.dao = new HemocentroDAO(simpleEntityManager.getEntityManager());
	}

	public void save(Hemocentro hemocentro) {
		try {
			simpleEntityManager.beginTransaction();
			// FAZER VALIDAÇÃO DE CAMPOS NULOS, ETC
			dao.save(hemocentro);
			simpleEntityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}

	public void delete(Hemocentro hemocentro) {
		try {
			simpleEntityManager.beginTransaction();
			dao.delete(hemocentro);
			simpleEntityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}

	public void update(Hemocentro hemocentro) {
		try {
			simpleEntityManager.beginTransaction();
			dao.update(hemocentro);
			simpleEntityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}

	public Hemocentro selectById(Long id) {
		return dao.getById(id);
	}

	public List<Hemocentro> findAll() {
		return dao.findAll(); // VERIFICAR SE NÃO RETORNA ERRO CASO LISTA FOR
								// VAZIA
	}
}
