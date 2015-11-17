package daos;

import managers.SimpleEntityManager;
import pojos.Doacao;
import pojos.Usuario;

public class DoacaoDAO extends SimpleEntityManager {

	public Doacao inseriDoacaoNoUsuario(Long idDoacao, Long idUsuario) {
		try {
			beginTransaction();
			Doacao doacaoRetornada = entityManager.find(Doacao.class, idDoacao);
			Usuario usuarioRetornado = entityManager.find(Usuario.class,
					idUsuario);
			doacaoRetornada.setUsuario(usuarioRetornado);
			Doacao doacaoAtualizada = entityManager.merge(doacaoRetornada);
			commit();
			return doacaoAtualizada;

		} catch (Exception e) {
			e.printStackTrace();
			rollBack();
		}
		return null;
	}

}
