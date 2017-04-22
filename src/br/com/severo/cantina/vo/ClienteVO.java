package br.com.severo.cantina.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.severo.cantina.entity.Cliente;
import br.com.severo.cantina.entity.Endereco;
import br.com.severo.cantina.entity.Telefone;
import br.com.severo.cantina.entity.TipoEndereco;
import br.com.severo.cantina.entity.TipoTelefone;

public class ClienteVO {
	private Cliente cliente; //cliente a ser cadastrado
	private List<Endereco> enderecos; // enderecos do cliente a ser cadastrado
	private List<Telefone> telefones; //telefones do cliente a ser cadastrado
	
	private List<TipoTelefone> tiposTelefone;
	private List<TipoEndereco> tiposEndereco;
	
	public ClienteVO() {
		this.cliente = new Cliente();
		this.enderecos = new ArrayList<>();
		this.telefones = new ArrayList<>();
		
		this.tiposTelefone = new ArrayList<TipoTelefone>(Arrays.asList(TipoTelefone.values()));
		this.tiposEndereco = new ArrayList<TipoEndereco>(Arrays.asList(TipoEndereco.values()));
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

	public List<TipoTelefone> getTiposTelefone() {
		return tiposTelefone;
	}

	public void setTiposTelefone(List<TipoTelefone> tiposTelefone) {
		this.tiposTelefone = tiposTelefone;
	}

	public List<TipoEndereco> getTiposEndereco() {
		return tiposEndereco;
	}

	public void setTiposEndereco(List<TipoEndereco> tiposEndereco) {
		this.tiposEndereco = tiposEndereco;
	}
	
}
