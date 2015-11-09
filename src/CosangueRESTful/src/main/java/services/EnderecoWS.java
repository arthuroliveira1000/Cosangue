package services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import json.Json;
import pojos.Endereco;

@Path("endereco")
public class EnderecoWS extends TemplateWS {
	
	@POST
	@Produces(Json.UTF8JSON)
	@Consumes(Json.UTF8JSON)
	public Endereco inserir(Endereco endereco) {
		try {
			Endereco novoEndereco = insert(endereco);
			return novoEndereco;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
