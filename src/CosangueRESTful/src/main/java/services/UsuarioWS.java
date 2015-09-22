package services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import json.Json;
import managers.SimpleEntityManager;
import pojos.Usuario;
import daos.UsuarioDAO;

@Path("teste")
public class UsuarioWS extends WSTemplate {

	private SimpleEntityManager simpleEntityManager = new SimpleEntityManager();
	private UsuarioDAO dao = new UsuarioDAO(
			simpleEntityManager.getEntityManager());

	@POST
	@Path("/inserir")
	@Produces(Json.UTF8JSON)
	@Consumes(Json.UTF8JSON)
	public Usuario inserir(Usuario usuario) {
		try {
			List<Usuario> retorno = dao.verificaLogin(usuario);
			if (retorno.isEmpty()) {
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

	/*@GET
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
					json = retorno.usuarioParaJSON();
					return json.toString();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
*/
	/*
	 * @GET
	 * 
	 * @Produces("text/plain") public String showHelloWord() { return
	 * "Olá mundo"; }
	 */



}
