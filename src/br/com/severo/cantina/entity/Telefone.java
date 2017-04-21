package br.com.severo.cantina.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@NamedQuery(name="TELEFONE.GETALL",query="select t from Telefone t")
@SequenceGenerator( name = "TELEFONE_ID", sequenceName = "CLIENTE_SEQ", allocationSize = 1 )
@Entity
public class Telefone {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TELEFONE_ID")
	private int id;
	private int ddd;
	private int numero;
	
	@Enumerated(EnumType.STRING)
	private TipoTelefone tipo;
	
	@ManyToOne
	private Cliente cliente;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDdd() {
		return ddd;
	}
	public void setDdd(int ddd) {
		this.ddd = ddd;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public TipoTelefone getTipo() {
		return tipo;
	}
	public void setTipo(TipoTelefone tipo) {
		this.tipo = tipo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
}
