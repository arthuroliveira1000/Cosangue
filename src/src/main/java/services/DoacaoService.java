package services;

import java.util.List;

import managers.SimpleEntityManager;
import daos.DoacaoDAO;
import entities.Doacao;

public class DoacaoService {

	private DoacaoDAO dao;
	private SimpleEntityManager simpleEntityManager;

	public DoacaoService(SimpleEntityManager simpleEntityManager) {
		super();
		this.simpleEntityManager = simpleEntityManager;
		this.dao = new DoacaoDAO(simpleEntityManager.getEntityManager());
	}

	public void save(Doacao doacao) {
		try {
			simpleEntityManager.beginTransaction();
			// FAZER VALIDAÇÃO DE CAMPOS NULOS, ETC
			dao.save(doacao);
			simpleEntityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}

	public List<Doacao> findAll() {
		return dao.findAll(); // VERIFICAR SE NÃO RETORNA ERRO CASO LISTA FOR
								// VAZIA
	}
}
