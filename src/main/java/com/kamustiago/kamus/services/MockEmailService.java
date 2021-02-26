package com.kamustiago.kamus.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

public class MockEmailService extends AbstractEmailService {

	
	private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);
	
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("SIMULANDO ENVIO DE EMAIL");
		LOG.info(msg.toString());
		LOG.info("EMAIL ENVIADO!");
		
	}


	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		LOG.info("SIMULANDO ENVIO DE EMAIL HTML");
		LOG.info(msg.toString());
		LOG.info("EMAIL ENVIADO!");
		
	}

}
