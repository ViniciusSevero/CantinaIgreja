package br.com.severo.cantina.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import br.com.severo.cantina.entity.Cliente;
import br.com.severo.cantina.entity.Endereco;
import br.com.severo.cantina.entity.Telefone;
import br.com.severo.cantina.entity.TipoEndereco;
import br.com.severo.cantina.entity.TipoTelefone;
import br.com.severo.cantina.repository.IClienteDao;

@Controller
public class UtilController {
	@Autowired 
	private IClienteDao dao;
	
	@RequestMapping(value="/telefones/tipos", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getTiposPhone(){
		return new Gson().toJson(Arrays.asList(TipoTelefone.values()));
	}
	
	@RequestMapping(value="/enderecos/tipos", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getTiposEndereco(){
		return new Gson().toJson(Arrays.asList(TipoEndereco.values()));
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
