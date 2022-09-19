package com.devsuperior.dsmeta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Venda;
import com.devsuperior.dsmeta.repositories.VendaRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.token}")
	private String twilioToken;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;
	
	@Autowired
	private VendaRepository vendaRepository;

	public void enviarSms(Long vendaId) {
		
		Venda venda = vendaRepository.findById(vendaId).get();
		
		String data = venda.getData().getMonthValue() + "/" + venda.getData().getYear();
		
		String msg = "O vendedor " + venda.getNomeVendedor() + " foi destaque em " + data
				   + " com um total de R$ " + String.format("%.2f", venda.getTotal());

		Twilio.init(twilioSid, twilioToken);

		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

		Message message = Message.creator(to, from, msg).create();

		System.out.println(message.getSid());
	}
}
