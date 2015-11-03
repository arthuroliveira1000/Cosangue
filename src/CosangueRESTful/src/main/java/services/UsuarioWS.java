package services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import json.Json;
import pojos.Usuario;
import daos.UsuarioDAO;

@Path("usuario")
public class UsuarioWS extends TemplateWS {

	private UsuarioDAO dao = new UsuarioDAO();

	@POST
	@Produces(Json.UTF8JSON)
	@Consumes(Json.UTF8JSON)
	public Usuario inserir(Usuario usuario) {
		try {
			Usuario retorno = dao.verificaLogin(usuario);
			if (retorno == null) {
				Usuario user = insert(usuario);
				return user;
			} else {
				System.out.println("O usuario ja existe");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@GET
	@Path("/{ID}")
	@Produces(Json.UTF8JSON)
	public Usuario buscaPorId(@PathParam("ID") Long ID) {
		try {
			Usuario usuario = selectOne(Usuario.class, ID);
			if (usuario != null) {
				return usuario;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@GET
	@Path("/{login}/{senha}")
	@Produces(Json.UTF8JSON)
	public Usuario login(@PathParam("login") String login,
			@PathParam("senha") String senha) {
		try {
			Usuario retorno = dao.autenticaLogin(login, senha);
			if (retorno != null) {
				System.out.println("Usuario existe, login pertitido :)");
				return retorno;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@PUT
	@Produces(Json.UTF8JSON)
	@Path("/{id}/{registration_id}")
	public Usuario inseriRegistrationId(@PathParam("id") Long id,
			@PathParam("registration_id") String registrationId) {
		try {
			Usuario user = dao.inseriRegistrationId(id, registrationId);
			if (user != null) {
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@PUT
	@Path("/{id}")
	public void removeRegistrationId(@PathParam("id") Long id) {
		try {
			Usuario user = dao.removeRegistrationId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * @DELETE
	 * 
	 * @Path("/remove/{ID}")
	 * 
	 * @Produces(Json.UTF8JSON) public Usuario remove(@PathParam("ID") Long ID)
	 * { try { Usuario verifica = selectOne(Usuario.class, ID); if (verifica !=
	 * null) { Usuario user = remove(ID); return user; } else {
	 * System.out.println("O usuario foi removido"); } } catch (Exception e) {
	 * e.printStackTrace(); } return null; }
	 */
}
