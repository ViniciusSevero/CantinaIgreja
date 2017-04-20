package br.com.severo.cantina.vo;

import java.util.ArrayList;
import java.util.List;

import br.com.severo.cantina.entity.Cliente;
import br.com.severo.cantina.entity.Endereco;
import br.com.severo.cantina.entity.Telefone;

public class ClienteVO {
	private Cliente cliente; //cliente a ser cadastrado
	private List<Endereco> enderecos; // enderecos do cliente a ser cadastrado
	private List<Telefone> telefones; //telefones do cliente a ser cadastrado
	
	public ClienteVO() {
		this.cliente = new Cliente();
		this.enderecos = new ArrayList<>();
		this.telefones = new ArrayList<>();
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
}
