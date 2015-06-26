package services;

import java.util.List;

import managers.SimpleEntityManager;
import daos.EventoDAO;
import entities.Evento;

public class EventoService {

	private EventoDAO dao;
	private SimpleEntityManager simpleEntityManager;

	public EventoService(SimpleEntityManager simpleEntityManager) {
		super();
		this.simpleEntityManager = simpleEntityManager;
		this.dao = new EventoDAO(simpleEntityManager.getEntityManager());
	}

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

	public List<Evento> findAll() {
		return dao.findAll(); // VERIFICAR SE NÃO RETORNA ERRO CASO LISTA FOR
								// VAZIA
	}

}
