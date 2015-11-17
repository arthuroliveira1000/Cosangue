package services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import json.Json;
import pojos.Doacao;
import pojos.Usuario;
import daos.DoacaoDAO;
import daos.UsuarioDAO;

@Path("doacao")
public class DoacaoWS extends TemplateWS {

	private DoacaoDAO daoDoacao = new DoacaoDAO();
	private UsuarioDAO daoUsuario = new UsuarioDAO();

	@POST
	@Produces(Json.UTF8JSON)
	@Consumes(Json.UTF8JSON)
	public Doacao inserir(Doacao doacaoRecebida) {
		try {

			if (doacaoRecebida != null) {
				Doacao doacao = insert(doacaoRecebida);
				return doacao;
			} else {
				System.out.println("Doação vindo nula");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@PUT
	@Produces(Json.UTF8JSON)
	@Consumes(Json.UTF8JSON)
	@Path("/{idDoacao}/{idUsuario}")
	public Usuario atualizaDoacao(@PathParam("idDoacao") Long idDoacao,
			@PathParam("idUsuario") Long idUsuario) {
		try {
			Doacao doacaoRetornada = daoDoacao.inseriDoacaoNoUsuario(idDoacao,
					idUsuario);
			if (doacaoRetornada != null) {
				Usuario usuario = daoUsuario.incrementaDoacaoDoUsuario(
						idUsuario, doacaoRetornada.getId());
				return usuario;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
