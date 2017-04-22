package br.com.severo.cantina.repository;

import br.com.severo.cantina.entity.Usuario;

public interface IUsuario extends Crud<String, Usuario>{
	
	public boolean validarUsuario(Usuario usuario) throws Exception;
}
