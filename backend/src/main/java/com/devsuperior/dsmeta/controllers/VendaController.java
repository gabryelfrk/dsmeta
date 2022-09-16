package com.devsuperior.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.entities.Venda;
import com.devsuperior.dsmeta.services.SmsService;
import com.devsuperior.dsmeta.services.VendaService;

@RestController
@RequestMapping(value = "/vendas")
public class VendaController {
	
	@Autowired
	private VendaService service;
	
	@Autowired
	private SmsService smsService;
	
	@GetMapping
	public Page<Venda> findVendas(
			@RequestParam(value = "dataMin", defaultValue = "") String dataMin, 
			@RequestParam(value = "dataMax", defaultValue = "") String dataMax, 
			Pageable pageable) {
		return service.findVendas(dataMin, dataMax, pageable);
	}
	
	@GetMapping("/{id}/notificacao")
	public void notificacaoSms(@PathVariable Long id) {
		smsService.enviarSms(id);
	}
}
