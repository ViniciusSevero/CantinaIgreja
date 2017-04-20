package br.com.severo.cantina.repository;

import org.springframework.stereotype.Repository;

public interface GenericDAO<T,K> {
	void cadastrar(T entidade);
	void atualizar(T entidade);
	void excluir(K codigo) throws Exception;
	T buscar(K codigo);
	void salvar() throws Exception;
}
