package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Venda;
import com.devsuperior.dsmeta.repositories.VendaRepository;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository repository;
	
	public Page<Venda> findVendas(String dataMin, String dataMax, Pageable pageable) {
		
		LocalDate hoje = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		LocalDate min = dataMin.equals("") ? hoje.minusDays(365) : LocalDate.parse(dataMin); // Converte de texto para localdate
		LocalDate max = dataMax.equals("") ? hoje : LocalDate.parse(dataMax);
		
		return repository.findVendas(min, max, pageable);
	}
}
