package br.com.severo.cantina.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.severo.cantina.entity.Endereco;

@Repository
@Transactional
public class EnderecoDAO implements IEnderecoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void insert(Endereco t) {
		manager.persist(t);
	}	

	@Override
	public void update(Endereco t) {
		manager.merge(t);		
	}

	@Override
	public void delete(Endereco t) {
		manager.remove(t);
	}

	@Override
	public List<Endereco> listAll() {
		TypedQuery<Endereco> q = manager.createNamedQuery("Endereco.GETALL",Endereco.class);
		return q.getResultList();
	}

	@Override
	public Endereco find(Integer pk) {
		return manager.find(Endereco.class, pk);
	}


}
