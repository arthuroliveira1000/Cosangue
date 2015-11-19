package cosangue.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cosangue.dao.AcaoDAO;
import cosangue.dao.HemocentroDAO;
import cosangue.model.Acao;
import cosangue.model.Hemocentro;

@Controller
public class LoginController {


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String abreTelaLogin(Model model) {
		return "Login";
	}
	
	@RequestMapping(value = "/entrar", method = RequestMethod.POST)
	public String abreTela(String login, String senha, Model model,
			HttpSession session) {
		HemocentroDAO hemocentroDAO = new HemocentroDAO();
		Hemocentro hemocentro = new Hemocentro();
		hemocentro = hemocentroDAO.login(login, senha);
		AcaoDAO acaoDAO = new AcaoDAO();
		if (hemocentro != null) {
			session.setAttribute("hemocentroLogado",
					hemocentro);
			model.addAttribute("hemocentro", hemocentro);
			ArrayList<Acao> eventos = acaoDAO.buscaAcoesPorHemocentro(hemocentro.getId());
			if (eventos != null) { 
				model.addAttribute("acao", eventos);
			}
			
			return "PaginaInicial";
		} else {
			return "Login";
		}
	}

	@RequestMapping(value = "/sair", method = RequestMethod.GET)
	public String invalidaSessao(HttpSession session) {
		session.invalidate();
		return "Login";
	}

}
