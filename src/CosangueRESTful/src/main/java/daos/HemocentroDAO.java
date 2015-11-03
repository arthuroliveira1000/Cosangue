package daos;

import java.util.List;

import javax.persistence.Query;

import managers.SimpleEntityManager;
import pojos.Hemocentro;

public class HemocentroDAO extends SimpleEntityManager {

	@SuppressWarnings("unchecked")
	public Hemocentro autenticaLogin(String login, String senha) {
		try {
			beginTransaction();
			final Query query = entityManager
					.createQuery("SELECT u FROM Hemocentro u WHERE u.login LIKE :login AND senha LIKE :senha");
			query.setParameter("login", login);
			query.setParameter("senha", senha);
			List<Hemocentro> retorno = query.getResultList();
			commit();
			if (retorno.isEmpty()) {
				return null;
			} else {
				return retorno.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			rollBack();
			return null;
		}
	}


}
