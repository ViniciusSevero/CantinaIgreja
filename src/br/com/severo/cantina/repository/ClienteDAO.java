package br.com.severo.cantina.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.severo.cantina.entity.Cliente;

@Repository
@Transactional
public class ClienteDAO implements IClienteDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void insert(Cliente t) {
		manager.persist(t);
	}	

	@Override
	public void update(Cliente t) {
		manager.merge(t);		
	}

	@Override
	public void delete(Cliente t) {
		manager.remove(t);
	}

	@Override
	public List<Cliente> listAll() {
		TypedQuery<Cliente> q = manager.createNamedQuery("CLIENTE.GETALL",Cliente.class);
		return q.getResultList();
	}

	@Override
	public Cliente find(Integer pk) {
		return manager.find(Cliente.class, pk);
	}

}
