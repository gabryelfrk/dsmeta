package com.devsuperior.dsmeta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Venda;
import com.devsuperior.dsmeta.repositories.VendaRepository;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository repository;
	
	public List<Venda> findVendas() {
		return repository.findAll();
	}
}
