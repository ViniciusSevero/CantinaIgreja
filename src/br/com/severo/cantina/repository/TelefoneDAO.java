package br.com.severo.cantina.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.severo.cantina.entity.Telefone;

@Repository
@Transactional
public class TelefoneDAO implements Crud<Integer, Telefone> {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void insert(Telefone t) {
		manager.persist(t);
	}	

	@Override
	public void update(Telefone t) {
		manager.merge(t);		
	}

	@Override
	public void delete(Telefone t) {
		manager.remove(t);
	}

	@Override
	public List<Telefone> listAll() {
		TypedQuery<Telefone> q = manager.createNamedQuery("Telefone.GETALL",Telefone.class);
		return q.getResultList();
	}

	@Override
	public Telefone find(Integer pk) {
		return manager.find(Telefone.class, pk);
	}

}
