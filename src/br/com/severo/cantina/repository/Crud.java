package br.com.severo.cantina.repository;

import java.util.List;

public interface Crud<Pk,T> {
	void insert(T t);
	void update(T t);
	void delete(T t);
	List<T> listAll();
	T find(Pk pk);
}
