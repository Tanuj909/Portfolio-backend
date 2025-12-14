package com.portfolio.mail.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.mail.entity.UserForm;
import com.portfolio.mail.repository.UserFormRepository;
import com.portfolio.mail.service.MailService;
import com.portfolio.mail.service.UserFormService;

@Service
public class UserFormServiceImpl implements UserFormService {

	@Autowired
	private UserFormRepository userFormRepository;
	
	@Autowired
	private MailService mailService;
	
	@Override
	public UserForm saveUserInfo(UserForm userForm) {
		UserForm user = new UserForm	();
		user.setName(userForm.getName());
		user.setEmail(userForm.getEmail());
		user.setSubject(userForm.getSubject());
		user.setMessage(userForm.getMessage());
		
		mailService.sendContactMail(user.getName(), user.getEmail(), user.getSubject(), user.getMessage());
		
		return userFormRepository.save(user);
	}

}
