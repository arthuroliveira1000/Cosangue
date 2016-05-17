package cosangue.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
		Hemocentro hemocentroLogado = (Hemocentro) session
				.getAttribute("hemocentroLogado");
		
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
	public String inserir(Acao acao, HttpSession session, Model model,
			Endereco endereco) {
		Hemocentro hemocentroLogado = (Hemocentro) session
				.getAttribute("hemocentroLogado");
		
		AcaoDAO acaoDAO = new AcaoDAO();
		EnderecoDAO enderecoDAO = new EnderecoDAO();

		if (hemocentroLogado == null) {
			return "Login";
		} else {
			acao.setHemocentro(hemocentroLogado);
			model.addAttribute("hemocentro", hemocentroLogado);
	
			SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formata2 = new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				Date data = formata2.parse(acao.getData());
				acao.setData(formata.format(data));
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Acao acaoRetornada = acaoDAO.inserir(acao);
			Endereco enderecoInserido = enderecoDAO.inserir(endereco);
			enderecoDAO.inseriAcaoNoEndereco(enderecoInserido.getId().toString(),
					acaoRetornada.getId().toString());

			ArrayList<Acao> eventos = acaoDAO.buscaAcoesPorHemocentro(hemocentroLogado.getId());
			if (eventos != null) {
				model.addAttribute("acao", eventos);
			}
			return "PaginaInicial";
		}
	}
	
	@RequestMapping(value = "/buscaEventoTeste", method = {RequestMethod.POST, RequestMethod.GET})
	public String busca(Long id, Model model, HttpSession session) {
		AcaoDAO acaoDAO = new AcaoDAO();
		Hemocentro hemocentroLogado = (Hemocentro) session.getAttribute("hemocentroLogado");
		if (hemocentroLogado == null) {
			return "Login";
		} else {
			model.addAttribute("hemocentroLogado", hemocentroLogado);
			if (id != null ) {
				Acao acaoRetornada = acaoDAO.buscaAcao(id);
				model.addAttribute("acao", acaoRetornada);
				model.addAttribute("categoria", Categoria.values());
				model.addAttribute("hemocomponente", Hemocomponentes.values());
				model.addAttribute("tipo", TipoSanguineo.values());
				return "VisualizaEvento";
			}
			else {
				return "PaginaInicial";
			}
		}
	}
	
	@RequestMapping(value = "/atualizaEvento", method = {RequestMethod.GET, RequestMethod.POST})
	public String atualizaEvento(Long id, Model model, HttpSession session) {
		AcaoDAO acaoDAO = new AcaoDAO();
		Hemocentro hemocentroLogado = (Hemocentro) session.getAttribute("hemocentroLogado");
		if (hemocentroLogado == null) {
			return "Login";
		} else {
			model.addAttribute("hemocentroLogado", hemocentroLogado);
			if (id != null ) {
				Acao acaoRetornada = acaoDAO.buscaAcao(id);
				SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat formata2 = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date data = formata.parse(acaoRetornada.getData());
					acaoRetornada.setData(formata2.format(data));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				model.addAttribute("acao", acaoRetornada);
				model.addAttribute("categorias", Categoria.values());
				model.addAttribute("tipos", TipoSanguineo.values());
				return "AtualizaEvento";
			}
			else {
				return "PaginaInicial";
			}
		}
	}
	
	@RequestMapping(value = "/atualizar", method = RequestMethod.POST)
	public String enviaEventoAtualizado(Acao acao, Endereco endereco, HttpSession session, Model model) {
		Hemocentro hemocentroLogado = (Hemocentro) session
				.getAttribute("hemocentroLogado");
		
		AcaoDAO acaoDAO = new AcaoDAO();
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		
		if (hemocentroLogado == null) {
			return "Login";
		} else {
			model.addAttribute("hemocentro", hemocentroLogado);
			SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formata2 = new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				Date data = formata2.parse(acao.getData());
				acao.setData(formata.format(data));	
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			Acao acaoRetornada = acaoDAO.buscaAcao(acao.getId());
			acaoDAO.atualizar(acao);
			endereco.setId(acaoRetornada.getEndereco().getId());
			enderecoDAO.atualizaEndereco(endereco);
			
			ArrayList<Acao> eventos = acaoDAO.buscaAcoesPorHemocentro(hemocentroLogado.getId());
			if (eventos != null) {
				model.addAttribute("acao", eventos);
			}
			return "PaginaInicial";
		}
	}
	
	@RequestMapping(value = "/excluiEvento", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String excluiEvento(Long id, HttpSession session, Model model) {
		Hemocentro hemocentroLogado = (Hemocentro) session
				.getAttribute("hemocentroLogado");
		AcaoDAO acaoDAO = new AcaoDAO();
		if (hemocentroLogado == null) {
			return "Login";
		} else {
			model.addAttribute("hemocentro", hemocentroLogado);
			if (id != null) {
				acaoDAO.excluir(id);
			}

			ArrayList<Acao> eventos = acaoDAO.buscaAcoesPorHemocentro(hemocentroLogado.getId());
			if (eventos != null) {
				model.addAttribute("acao", eventos);
			}
			return "PaginaInicial";
		}
	}
}
