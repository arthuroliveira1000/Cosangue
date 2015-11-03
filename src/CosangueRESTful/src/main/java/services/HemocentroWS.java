package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import json.Json;
import pojos.Hemocentro;
import daos.HemocentroDAO;

@Path("hemocentro")
public class HemocentroWS extends TemplateWS {
	
	private HemocentroDAO dao = new HemocentroDAO();
	
	@GET
	@Path("/{login}/{senha}")
	@Produces(Json.UTF8JSON)
	public Hemocentro login(@PathParam("login") String login,
			@PathParam("senha") String senha) {
		try {
			Hemocentro retorno = dao.autenticaLogin(login, senha);
			if (retorno != null) {
				System.out.println("Hemocentro existe, login pertitido :)");
				return retorno;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
