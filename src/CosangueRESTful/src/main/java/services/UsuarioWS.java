package services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import json.Json;
import managers.SimpleEntityManager;

import org.json.JSONObject;

import pojos.Usuario;
import daos.UsuarioDAO;

@Path("teste")
// o @path define a URI do recurso que nesse caso será /usuarioWS
public class UsuarioWS {

	private SimpleEntityManager simpleEntityManager = new SimpleEntityManager();
	private UsuarioDAO dao = new UsuarioDAO(
			simpleEntityManager.getEntityManager());

	/*
	 * @GET
	 * 
	 * @Produces("text/plain") public String showHelloWord() { return
	 * "Olá mundo"; }
	 */

	/*@GET
	@Path("/insert/{name}")
	@Produces(Json.UTF8JSON)
	public String inserir(@PathParam("name") String name) {
		JSONObject json = null;
		try {
			Usuario user = new Usuario(name);
			dao.save(user);
			if (user != null) {
				json = user.toJSON();
				return json.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}*/
	
	@GET
	@Path("/inserirTeste/{jsonUsuario}")
	@Produces(Json.UTF8JSON)
	public String inserirTeste(@PathParam("jsonUsuario") JSONObject jsonUsuario) {
		JSONObject json = null;
		Usuario usuario = new Usuario();
		
		try {
			usuario = usuario.fromJSON(jsonUsuario);
			
			List <Usuario> retorno = dao.verificaLogin(usuario);
			
			if (retorno.isEmpty()) {
				dao.save(usuario);
				json = usuario.toJSON();
				return json.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@GET
	@Path("/{ID}")
	@Produces(Json.UTF8JSON)
	public String selectOneByID(@PathParam("ID") Long ID) {
		JSONObject json = null;
		try {
			Usuario user = new Usuario(ID);
			dao.getById(ID);
			if (user != null) {
				json = user.toJSON();
				return json.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@GET
	@Path("/login/{jsonUsuario}")
	@Produces(Json.UTF8JSON)
	@Consumes(Json.UTF8JSON)
	public String login(@PathParam("jsonUsuario") JSONObject jsonUsuario) {
		Usuario usuario = new Usuario();
		try {
			usuario = usuario.fromJSON(jsonUsuario);
			if (usuario != null) {
				Usuario retorno = (Usuario) dao.verificaLogin(usuario).get(0);
				if (retorno != null) {
					JSONObject json = null;
					json = retorno.userToJSON();
					return json.toString();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
