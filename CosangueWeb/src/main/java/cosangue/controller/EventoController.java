package cosangue.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cosangue.dao.AcaoDAO;
import cosangue.dao.EnderecoDAO;
import cosangue.model.Acao;
import cosangue.model.Categoria;
import cosangue.model.Endereco;
import cosangue.model.Hemocentro;
import cosangue.model.Hemocomponentes;

@Controller
public class EventoController {
	
	@RequestMapping(value = "/telaCriaEvento", method = RequestMethod.GET)
	public String abreTelaCriaEvento(HttpSession session, Model model) {
		Hemocentro hemocentroLogado = (Hemocentro) session.getAttribute("hemocentroLogado");
		if (hemocentroLogado == null) {
			return "Login";
		} else {
			model.addAttribute("categoria", Categoria.values());
			model.addAttribute("hemocomponente", Hemocomponentes.values());
			return "CriaEvento";
		}
		
	}
	
	@RequestMapping(value = "/criar", method = RequestMethod.POST)
	public String inserir(Acao acao, HttpSession session, Model model, Endereco endereco) {
		Hemocentro hemocentroLogado = (Hemocentro) session.getAttribute("hemocentroLogado");
		AcaoDAO acaoDAO = new AcaoDAO();
		
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		
		if (hemocentroLogado == null) {
			return "Login";
		} else {
			acao.setHemocentro(hemocentroLogado);
			model.addAttribute("hemocentro", hemocentroLogado);
			ArrayList<Acao> eventos = acaoDAO.listaEventos();
			if (eventos != null) { 
				model.addAttribute("acao", eventos);
			}
			
			Acao acaoRetornada = acaoDAO.inserir(acao);
			Endereco enderecoInserido = enderecoDAO.inserir(endereco);
			enderecoDAO.atualizaEndereco(enderecoInserido.getId().toString(), acaoRetornada.getId().toString());
			

		    return "PaginaInicial";
		}
	}
}
