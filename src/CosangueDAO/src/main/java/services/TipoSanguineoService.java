package services;

import java.util.List;

import managers.SimpleEntityManager;
import daos.TipoSanguineoDAO;
import entities.Sangue;

public class TipoSanguineoService {

	private SimpleEntityManager simpleEntityManager = new SimpleEntityManager();
	private TipoSanguineoDAO dao = new TipoSanguineoDAO(
			simpleEntityManager.getEntityManager());

	public void save(Sangue tipoSanguineo) {
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

	public void delete(Sangue tipoSanguineo) {
		try {
			simpleEntityManager.beginTransaction();
			dao.delete(tipoSanguineo);
			simpleEntityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}

	public void update(Sangue tipoSanguineo) {
		try {
			simpleEntityManager.beginTransaction();
			dao.update(tipoSanguineo);
			simpleEntityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}

	public Sangue selectById(Long id) {
		return dao.getById(id);
	}

	public List<Sangue> findAll() {
		return dao.findAll(); // VERIFICAR SE NÃO RETORNA ERRO CASO LISTA FOR
								// VAZIA
	}

}
