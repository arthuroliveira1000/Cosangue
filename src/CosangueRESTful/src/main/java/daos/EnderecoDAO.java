package daos;

import javax.persistence.EntityManager;

import pojos.Endereco;

public class EnderecoDAO extends GenericDAO<Long, Endereco> {

	public EnderecoDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
