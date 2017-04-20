package br.com.severo.cantina.repository;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class GenericDAOImpl<T,K> implements GenericDAO<T, K> {
	private Class<T> clazz;
	
	@PersistenceContext
	private EntityManager manager;
	
	public GenericDAOImpl() {
		//clazz = (Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public void cadastrar(T entidade) {
		manager.persist(entidade);	
	}

	@Override
	public void atualizar(T entidade) {
		manager.merge(entidade);	
		
	}

	@Override
	public void excluir(K codigo) throws Exception{
		T entidade = manager.find(clazz, codigo);
		if(entidade == null){
			throw new Exception("Entity not found");
		}
		manager.remove(entidade);	
	}

	@Override
	public T buscar(K codigo) {
		T entidade = manager.find(clazz, codigo);
		return entidade;
	}

	@Override
	public void salvar() throws Exception {
		try{
			manager.getTransaction().begin();
			manager.getTransaction().commit();
		}catch(Exception e){
			if(manager.getTransaction().isActive()){
				manager.getTransaction().rollback();
			}
			throw new Exception("Erro");
		}
	}
	
}
