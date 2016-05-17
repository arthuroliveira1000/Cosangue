package cosangue.dao;


import resttemplate.SimpleRestTemplate;
import utils.Constantes;
import cosangue.model.Hemocentro;

public class HemocentroDAO extends SimpleRestTemplate {
	
	public Hemocentro login(String... params) {
		
		return restTemplate.getForObject(Constantes.URL_LOGIN_HEMOCENTRO, Hemocentro.class, params);
	}

	
}
