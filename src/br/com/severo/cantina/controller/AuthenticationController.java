package br.com.severo.cantina.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.severo.cantina.entity.Usuario;
import br.com.severo.cantina.repository.IUsuario;

@Controller
public class AuthenticationController {
	
	@Autowired
	private IUsuario dao;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getFormLogin(){
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String efetuaLogin(Usuario usuario, Model model, HttpSession session){
		try {
			if(dao.validarUsuario(usuario)){
				session.setAttribute("usuarioLogado", usuario.getLogin());
				return "redirect:"+"/cliente/listagem";
			}
			model.addAttribute("msg","Usuário e/ou senha inválidos");
			model.addAttribute("typeMsg","alert alert-danger");
			return "login";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg",e.getMessage());
			model.addAttribute("typeMsg","alert alert-danger");
			return "login";
		}
			
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:"+"/login";
	}
	
	

}
