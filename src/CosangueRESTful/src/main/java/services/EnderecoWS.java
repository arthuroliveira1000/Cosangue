package services;

import gcm.GoogleCloudMessaging;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import json.Json;
import pojos.Acao;
import pojos.Endereco;
import daos.AcaoDAO;
import daos.EnderecoDAO;

@Path("endereco")
public class EnderecoWS extends TemplateWS {
	
	EnderecoDAO enderecoDAO = new EnderecoDAO();
	AcaoDAO acaoDAO = new AcaoDAO();
	
	@PUT
	@Produces(Json.UTF8JSON)
	@Consumes(Json.UTF8JSON)
	@Path("/{idEndereco}/{idAcao}")
	public Endereco insereAcaoNoEndereco(@PathParam("idEndereco") Long idEndereco,
			@PathParam("idAcao") Long idAcao) {
		try {
			Endereco enderecoRetornado = enderecoDAO.insereAcaoNoEndereco(idEndereco, idAcao);
			if (enderecoRetornado != null) {
				Acao acaoRetornada = selectOne(Acao.class, idAcao);
				if (acaoRetornada != null) {
					GoogleCloudMessaging.ExecutaPost(acaoRetornada);
				}
				return enderecoRetornado;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PUT
	@Produces(Json.UTF8JSON)
	@Consumes(Json.UTF8JSON)
	public Endereco atualizaEndereco(Endereco endereco) {
		try {
			Endereco enderecoRetornado = enderecoDAO.atualizaEndereco(endereco);
			if (enderecoRetornado != null) {
				return enderecoRetornado;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
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
	
	@GET
	@Path("/{ID}")
	@Produces(Json.UTF8JSON)
	public Endereco buscaPorId(@PathParam("ID") Long ID) {
		try {
			Endereco endereco = selectOne(Endereco.class, ID);
			if (endereco != null) {
				return endereco;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
