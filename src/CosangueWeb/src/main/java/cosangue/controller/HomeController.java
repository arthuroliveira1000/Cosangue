package cosangue.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cosangue.dao.AcaoDAO;
import cosangue.model.Acao;
import cosangue.model.Categoria;
import cosangue.model.Hemocentro;
import cosangue.model.Hemocomponentes;

@Controller
public class HomeController {

	@RequestMapping(value = "/listaEventos", method = RequestMethod.GET)
	public String listaEvento(Acao acao, HttpSession session, Model model) {
		Hemocentro hemocentroLogado = (Hemocentro) session.getAttribute("hemocentroLogado");
		 AcaoDAO acaoDAO = new AcaoDAO();
		if (hemocentroLogado == null) {
			return "Login";
		} else {
			ArrayList<Acao> eventos = acaoDAO.buscaAcoesPorHemocentro(hemocentroLogado.getId());
			if (eventos != null) { 
				model.addAttribute("acao", eventos);
				model.addAttribute("categoria", Categoria.values());
				model.addAttribute("hemocomponente", Hemocomponentes.values());
			}
			return "PaginaInicial";
		}
	}

}
