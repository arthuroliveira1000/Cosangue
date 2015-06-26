package services;

import java.util.List;

import managers.SimpleEntityManager;
import daos.ComentarioDAO;
import entities.Comentario;

public class ComentarioService {
	private ComentarioDAO dao;
	private SimpleEntityManager simpleEntityManager;

	public ComentarioService(SimpleEntityManager simpleEntityManager) {
		super();
		this.simpleEntityManager = simpleEntityManager;
		this.dao = new ComentarioDAO(simpleEntityManager.getEntityManager());
	}

	public void save(Comentario comentario) {
		try {
			simpleEntityManager.beginTransaction();
			// FAZER VALIDAÇÃO DE CAMPOS NULOS, ETC
			dao.save(comentario);
			simpleEntityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}

	public List<Comentario> findAll() {
		return dao.findAll(); // VERIFICAR SE NÃO RETORNA ERRO CASO LISTA FOR
								// VAZIA
	}
}
