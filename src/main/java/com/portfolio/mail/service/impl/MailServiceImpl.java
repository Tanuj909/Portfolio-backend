package com.portfolio.mail.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.portfolio.mail.service.MailService;

import jakarta.annotation.PostConstruct;

@Service
public class MailServiceImpl implements MailService{
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
	private String adminMail;
	
	
    @PostConstruct
    public void debug() {
        System.out.println("MAIL PASSWORD LOADED = " + (adminMail != null));
    }

	@Override
	public void sendContactMail(String name, String email, String subject ,String message) {
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(adminMail);
		mail.setSubject("New PortFolio Message");
		mail.setText(
	            "New message received:\n\n" +
	            "Name: " + name + "\n" +
	            "Email: " + email + "\n\n" +
	            "Subject: " + subject + "\n\n" + 
	            "Message:\n" + message
				);
		mailSender.send(mail);
	}

}
