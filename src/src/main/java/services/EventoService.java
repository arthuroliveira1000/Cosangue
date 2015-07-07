package services;

import java.util.List;

import managers.SimpleEntityManager;
import daos.EventoDAO;
import entities.Evento;

public class EventoService {

	private SimpleEntityManager simpleEntityManager = new SimpleEntityManager();
	private EventoDAO dao = new EventoDAO(
			simpleEntityManager.getEntityManager());

	public void save(Evento evento) {
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

	public void delete(Evento evento) {
		try {
			simpleEntityManager.beginTransaction();
			dao.delete(evento);
			simpleEntityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}

	public void update(Evento evento) {
		try {
			simpleEntityManager.beginTransaction();
			dao.update(evento);
			simpleEntityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}

	public Evento selectById(Long id) {
		return dao.getById(id);
	}

	public List<Evento> findAll() {
		return dao.findAll(); // VERIFICAR SE NÃO RETORNA ERRO CASO LISTA FOR
								// VAZIA
	}

}
