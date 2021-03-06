package services;

import java.util.List;

import managers.SimpleEntityManager;
import daos.TipoSanguineoDAO;
import entities.TipoSanguineo;

public class TipoSanguineoService {

	private SimpleEntityManager simpleEntityManager = new SimpleEntityManager();
	private TipoSanguineoDAO dao = new TipoSanguineoDAO(
			simpleEntityManager.getEntityManager());

	public void save(TipoSanguineo tipoSanguineo) {
		try {
			simpleEntityManager.beginTransaction();
			// FAZER VALIDA��O DE CAMPOS NULOS, ETC
			dao.save(tipoSanguineo);
			simpleEntityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}

	public void delete(TipoSanguineo tipoSanguineo) {
		try {
			simpleEntityManager.beginTransaction();
			dao.delete(tipoSanguineo);
			simpleEntityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}

	public void update(TipoSanguineo tipoSanguineo) {
		try {
			simpleEntityManager.beginTransaction();
			dao.update(tipoSanguineo);
			simpleEntityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}

	public TipoSanguineo selectById(Long id) {
		return dao.getById(id);
	}

	public List<TipoSanguineo> findAll() {
		return dao.findAll(); // VERIFICAR SE N�O RETORNA ERRO CASO LISTA FOR
								// VAZIA
	}

}
