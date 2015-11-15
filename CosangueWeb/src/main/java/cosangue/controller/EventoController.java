package cosangue.controller;

import java.util.ArrayList;
import java.util.List;

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
import cosangue.model.TipoSanguineo;

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
			model.addAttribute("tipo", TipoSanguineo.values());
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
	
	@RequestMapping(value = "/visualizaEvento", method = {RequestMethod.POST, RequestMethod.GET})
	public String visualizaEvento(Long id, HttpSession session, Model model) {
		Hemocentro hemocentroLogado = (Hemocentro) session.getAttribute("hemocentroLogado");
		AcaoDAO acaoDAO = new AcaoDAO();
		if (hemocentroLogado == null) {
			return "Login";
		} else {
			model.addAttribute("hemocentro", hemocentroLogado);
			 
			Acao acaoRetornada = acaoDAO.buscaAcao(id);
			if (acaoRetornada != null) {
				model.addAttribute("acao", acaoRetornada);
				model.addAttribute("categoria", Categoria.values());
				model.addAttribute("tipo", TipoSanguineo.values());
			}
			return "VisualizaEvento";
		}
	}
	
	@RequestMapping(value = "/excluiEvento", method = {RequestMethod.POST, RequestMethod.GET})
	public String excluiEvento(Long id, HttpSession session, Model model) {
		Hemocentro hemocentroLogado = (Hemocentro) session.getAttribute("hemocentroLogado");
		AcaoDAO acaoDAO = new AcaoDAO();
		AcaoDAO acaoDAO1 = new AcaoDAO();
		if (hemocentroLogado == null) {
			return "Login";
		} else {
			model.addAttribute("hemocentro", hemocentroLogado);	 
		//	Acao acaoRetornada = acaoDAO.buscaAcao(id);
			/*if (acaoRetornada != null) {
				acaoDAO1.excluir(acaoRetornada);
			}
			*/
			acaoDAO.excluir(id);
			model.addAttribute("acao", acaoDAO1.listaEventos());
			return "PaginaInicial";
			
		}
	}
}
