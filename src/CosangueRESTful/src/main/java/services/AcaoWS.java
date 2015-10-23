package services;

import gcm.GoogleCloudMessaging;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import json.Json;
import pojos.Acao;

public class AcaoWS extends TemplateWS {

	@POST
	@Produces(Json.UTF8JSON)
	@Consumes(Json.UTF8JSON)
	public Acao inserir(Acao acao) {
		try {
			Acao novaAcao = insert(acao);
			GoogleCloudMessaging.ExecutaPost(novaAcao);
			return novaAcao;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@GET
	@Path("/{ID}")
	@Produces(Json.UTF8JSON)
	public Acao buscaPorId(@PathParam("ID") Long ID) {
		try {
			Acao acao = selectOne(Acao.class, ID);
			if (acao != null) {
				return acao;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
