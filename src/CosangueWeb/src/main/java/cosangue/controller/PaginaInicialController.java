package cosangue.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cosangue.dao.AcaoDAO;
import cosangue.model.Acao;
import cosangue.model.Hemocentro;

@Controller
public class PaginaInicialController {

	@RequestMapping(value = "/PaginaInicial", method = RequestMethod.GET)
	public String abrePaginaInicial(Model model, HttpSession session) {
	
		Hemocentro hemocentroLogado = (Hemocentro) session.getAttribute("hemocentroLogado");
		AcaoDAO acaoDAO = new AcaoDAO();
		
		if (hemocentroLogado != null) {
			ArrayList<Acao> eventos = acaoDAO.buscaAcoesPorHemocentro(hemocentroLogado.getId());
			if (eventos != null) { 
				model.addAttribute("hemocentroLogado", hemocentroLogado);
				model.addAttribute("acao", eventos);
			}
			return "PaginaInicial";
		}
		return "Login";

	}

}
