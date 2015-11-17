package services;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import json.Json;
import pojos.Acao;
import daos.AcaoDAO;
import daos.UsuarioDAO;

@Path("acao")
public class AcaoWS extends TemplateWS {

	AcaoDAO daoAcao = new AcaoDAO();
	UsuarioDAO daoUsuario = new UsuarioDAO();

	@POST
	@Produces(Json.UTF8JSON)
	@Consumes(Json.UTF8JSON)
	public Acao inserir(Acao acao) {
		try {
			Acao novaAcao = insert(acao);
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

	@GET
	@Produces(Json.UTF8JSON)
	public ArrayList<Acao> buscaAcoes() {
		try {
			ArrayList<Acao> acao = new ArrayList<Acao>();
			acao = daoAcao.listaAcoes();
			if (acao != null) {
				return acao;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@PUT
	@Produces(Json.UTF8JSON)
	@Consumes(Json.UTF8JSON)
	public Acao atualizar(Acao acao) {
		try {
			Acao atualizaAcao = update(acao);
			return atualizaAcao;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletar(Acao acao) {
		try {
			delete(acao);
			return Response.status(200).entity("Açao excluída com sucesso")
					.build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@PUT
	@Produces(Json.UTF8JSON)
	@Consumes(Json.UTF8JSON)
	@Path("/{idAcao}/{idUsuario}")
	public Acao atualizaAcao(@PathParam("idAcao") Long idAcao,
			@PathParam("idUsuario") Long idUsuario) {
		try {
			Acao acaoRetornada = daoAcao.inseriAcaoNoUsuario(idAcao, idUsuario);
			if (acaoRetornada != null) {
				return acaoRetornada;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
