package services;

import java.util.List;

import managers.SimpleEntityManager;
import daos.UsuarioDAO;
import entities.Usuario;

public class UsuarioService {

	private SimpleEntityManager simpleEntityManager = new SimpleEntityManager();
	private UsuarioDAO dao = new UsuarioDAO(
			simpleEntityManager.getEntityManager());

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

	public void delete(Usuario usuario) {
		try {
			simpleEntityManager.beginTransaction();
			dao.delete(usuario);
			simpleEntityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}

	public void update(Usuario usuario) {
		try {
			simpleEntityManager.beginTransaction();
			dao.update(usuario);
			simpleEntityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}

	public Usuario selectById(Long id) {
		return dao.getById(id);
	}

	public List<Usuario> findAll() {
		return dao.findAll(); // VERIFICAR SE NÃO RETORNA ERRO CASO LISTA FOR
								// VAZIA
	}

}
