package br.com.severo.cantina.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.severo.cantina.entity.Cliente;
import br.com.severo.cantina.entity.Endereco;
import br.com.severo.cantina.entity.Telefone;
import br.com.severo.cantina.repository.IClienteDao;
import br.com.severo.cantina.vo.ClienteVO;

@Controller
public class ClienteController {
	@Autowired 
	private IClienteDao dao;
	
	@RequestMapping("/cliente/cadastro")
	public String getForm(Model model){
		ClienteVO vo = new ClienteVO();
		model.addAttribute("vo",vo);
		return "cadastro";
	}
	
	@RequestMapping("/cliente/salvar")
	public String cadastrar(Cliente cliente){
		removerElementosVazios(cliente);
		
		for (Endereco endereco : cliente.getEnderecos()) {
			endereco.setCliente(cliente);
		}
		for (Telefone telefone : cliente.getTelefones()) {
			telefone.setCliente(cliente);
		}
		dao.insert(cliente);
		return "cadastro";
	}
	
	@RequestMapping("/cliente/alterar")
	public String salvar(Cliente cliente) throws IOException{
		removerElementosVazios(cliente);
		
		for (Endereco endereco : cliente.getEnderecos()) {
			endereco.setCliente(cliente);
		}
		for (Telefone telefone : cliente.getTelefones()) {
			telefone.setCliente(cliente);
		}
		dao.update(cliente);
		return "redirect:"+"/cliente/"+cliente.getId();
	}
	
	@RequestMapping(value = "/cliente/{id}", method=RequestMethod.GET)
	public String getOrder(@PathVariable int id, Model model){	
		ClienteVO vo = new ClienteVO();
		vo.setCliente(dao.find(id));
		System.out.println(vo.getCliente().getTelefones().size());
		System.out.println(vo.getCliente().getTelefones().size());
		System.out.println(vo.getCliente().getTelefones().size());
		model.addAttribute("vo",vo);
		return "detalhe";
	}
	
	@RequestMapping("/cliente/listagem")
	public String getClientes(Model model){
		model.addAttribute("lista", dao.listAll());
		return "listagem";
	}
	
	public void removerElementosVazios(Cliente cliente){
		for (int i = 0; i < cliente.getEnderecos().size(); i++) {
			if(cliente.getEnderecos().get(i).getCep() == null || cliente.getEnderecos().get(i).getCep() == ""){
				cliente.getEnderecos().remove(i);
			}
		}
		for (int i = 0; i < cliente.getTelefones().size(); i++) {
			if(cliente.getTelefones().get(i).getNumero() == 0){
				cliente.getTelefones().remove(i);
			}
		}
	}
	
}
