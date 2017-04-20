package br.com.severo.cantina.repository;

import org.springframework.stereotype.Repository;

import br.com.severo.cantina.entity.Cliente;

@Repository
public class ClienteDAOImpl extends GenericDAOImpl<Cliente, Integer> implements ClienteDAO {


}
