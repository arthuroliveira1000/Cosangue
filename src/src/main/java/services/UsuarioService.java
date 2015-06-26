package services;

import java.util.List;

import managers.SimpleEntityManager;
import daos.UsuarioDAO;
import entities.Usuario;

public class UsuarioService {

	private UsuarioDAO dao;
	private SimpleEntityManager simpleEntityManager;

	public UsuarioService(SimpleEntityManager simpleEntityManager) {
		super();
		this.simpleEntityManager = simpleEntityManager;
		this.dao = new UsuarioDAO(simpleEntityManager.getEntityManager());
	}

	public void save(Usuario usuario) {
		try {
			simpleEntityManager.beginTransaction();
			// FAZER VALIDAÇÃO DE CAMPOS NULOS, ETC
			dao.save(usuario);
			simpleEntityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}

	public List<Usuario> findAll() {
		return dao.findAll(); // VERIFICAR SE NÃO RETORNA ERRO CASO LISTA FOR
								// VAZIA
	}

}
