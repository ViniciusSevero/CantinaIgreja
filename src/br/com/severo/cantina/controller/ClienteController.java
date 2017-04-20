package br.com.severo.cantina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.severo.cantina.entity.Cliente;
import br.com.severo.cantina.repository.ClienteDAO;
import br.com.severo.cantina.vo.ClienteVO;

@Controller
@Transactional
public class ClienteController {
	@Autowired 
	private ClienteDAO dao;
	
	@RequestMapping("/cliente/cadastro")
	public String getForm(){
		return "cadastro";
	}
	
	@RequestMapping("/cliente/salvar")
	public String cadastrar(Cliente cliente){
		dao.insert(cliente);
		return "cadastro";
	}
	
	@RequestMapping("/cliente/listagem")
	public String getClientes(Model model){
		model.addAttribute("lista", dao.listAll());
		return "listagem";
	}
}
