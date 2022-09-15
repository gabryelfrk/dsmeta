package com.devsuperior.dsmeta.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_vendas")
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeVendedor;
	private Integer visitas;
	private Integer vendas;
	private Double total;
	private LocalDate data;
	
	public Venda() {
	}

	public Venda(Long id, String nomeVendedor, Integer visitas, Integer vendas, Double total, LocalDate data) {
		this.id = id;
		this.nomeVendedor = nomeVendedor;
		this.visitas = visitas;
		this.vendas = vendas;
		this.total = total;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}

	public Integer getVisitas() {
		return visitas;
	}

	public void setVisitas(Integer visitas) {
		this.visitas = visitas;
	}

	public Integer getVendas() {
		return vendas;
	}

	public void setVendas(Integer vendas) {
		this.vendas = vendas;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	
}
