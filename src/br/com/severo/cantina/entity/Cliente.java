package br.com.severo.cantina.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@NamedQuery(name="CLIENTE.GETALL",query="select c from Cliente c")
@SequenceGenerator( name = "CLIENTE_ID", sequenceName = "CLIENTE_SEQ", allocationSize = 1 )
@Entity
public class Cliente {
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "CLIENTE_ID" )
	private int id;
	
	@Column(nullable=false)
	private String nome;
	
	@OneToMany(mappedBy="cliente", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Endereco> enderecos = new ArrayList<>();
	
	@OneToMany(mappedBy="cliente", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Telefone> telefones = new ArrayList<>();;
	
	public void cadastrarEndereco(Endereco endereco){
		endereco.setCliente(this);
		this.enderecos.add(endereco);
	}
	
	public void cadastrarTelefone(Telefone telefone){
		telefone.setCliente(this);
		this.telefones.add(telefone);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
