package services;

import java.util.List;

import managers.SimpleEntityManager;
import daos.TipoSanguineoDAO;
import entities.TipoSanguineo;

public class TipoSanguineoService {

	private TipoSanguineoDAO dao;
	private SimpleEntityManager simpleEntityManager;

	public TipoSanguineoService(SimpleEntityManager simpleEntityManager) {
		super();
		this.simpleEntityManager = simpleEntityManager;
		this.dao = new TipoSanguineoDAO(simpleEntityManager.getEntityManager());
	}

	public void save(TipoSanguineo tipoSanguineo) {
		try {
			simpleEntityManager.beginTransaction();
			// FAZER VALIDAÇÃO DE CAMPOS NULOS, ETC
			dao.save(tipoSanguineo);
			simpleEntityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}

	public List<TipoSanguineo> findAll() {
		return dao.findAll(); // VERIFICAR SE NÃO RETORNA ERRO CASO LISTA FOR
								// VAZIA
	}

}
