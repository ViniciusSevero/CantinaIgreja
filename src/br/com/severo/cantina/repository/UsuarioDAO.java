package br.com.severo.cantina.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.dom4j.util.UserDataDocumentFactory;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.severo.cantina.entity.Usuario;

@Repository
@Transactional
public class UsuarioDAO implements IUsuario{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void insert(Usuario t) {
		manager.persist(t);
	}

	@Override
	public void update(Usuario t) {
		manager.merge(t);
		
	}

	@Override
	public void delete(Usuario t) {
		manager.remove(t);
		
	}

	@Override
	public List<Usuario> listAll() {
		return null; //não implementado
	}

	@Override
	public Usuario find(String pk){
		try{
			Query q = manager.createQuery("select u from Usuario u where u.login = :login");
			q.setParameter("login", pk);
			return (Usuario) q.getSingleResult();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public boolean validarUsuario(Usuario usuario) throws Exception {
		Usuario user = find(usuario.getLogin());
		if(user == null)
			throw new Exception("Usuário inválido");
		if(!usuario.getSenha().equals(user.getSenha()))
			throw new Exception("Senha inválida");
		
		return true;
	}


}
