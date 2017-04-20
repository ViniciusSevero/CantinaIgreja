package br.com.severo.cantina.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQuery(name="CLIENTE.GETALL",query="select c from Cliente c")
@Entity
public class Cliente {
	@Id @GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private String nome;
	
	@OneToMany(mappedBy="cliente", cascade=CascadeType.ALL)
	private List<Endereco> enderecos;
	
	@OneToMany(mappedBy="cliente", cascade=CascadeType.ALL)
	private List<Telefone> telefones;
	
	public void cadastrarEndereco(Endereco endereco){
		endereco.setCliente(this);
		this.enderecos.add(endereco);
	}
	
	public void cadastrarTelefone(Telefone telefone){
		telefone.setCliente(this);
		this.telefones.add(telefone);
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
