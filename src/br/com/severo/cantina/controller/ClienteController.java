package br.com.severo.cantina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.severo.cantina.entity.Cliente;
import br.com.severo.cantina.entity.Endereco;
import br.com.severo.cantina.entity.Telefone;
import br.com.severo.cantina.entity.TipoEndereco;
import br.com.severo.cantina.entity.TipoTelefone;
import br.com.severo.cantina.repository.ClienteDAO;
import br.com.severo.cantina.repository.IClienteDao;

@Controller
public class ClienteController {
	@Autowired 
	private IClienteDao dao;
	
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
	
	@RequestMapping("/cliente/popula")
	public String popula(){
		Cliente c = new Cliente();
		c.setNome("Inês");
		
		Endereco e = new Endereco();
		e.setCep("08420680");
		e.setBairro("Jardim São Pedro");
		e.setCidade("São Paulo");
		e.setEstado("SP");
		e.setLogradouro("Rua Silvianópolis");
		e.setNumero(275);
		e.setTipoEndereco(TipoEndereco.RESIDENCIAL);
		
		Telefone t = new Telefone();
		t.setDdd(11);
		t.setNumero(25578896);
		t.setTipo(TipoTelefone.FIXO);
		
		c.cadastrarEndereco(e);
		c.cadastrarTelefone(t);
		
		dao.insert(c);
		return "cadastro";
	}
}
