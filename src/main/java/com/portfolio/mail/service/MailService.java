package com.portfolio.mail.service;

public interface MailService {
	
	void sendContactMail(String name, String email, String subject ,String message);

}
