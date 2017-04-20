package br.com.severo.cantina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.severo.cantina.repository.ClienteDAO;

@Controller
public class ClienteController {
	@Autowired 
	@Qualifier("clienteDAOImpl")
	private ClienteDAO dao;
	
	@RequestMapping("/cliente")
	public String getForm(){
		return "cadastro";
	}
}
