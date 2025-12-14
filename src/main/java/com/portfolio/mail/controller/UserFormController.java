package com.portfolio.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portfolio.mail.entity.UserForm;
import com.portfolio.mail.service.UserFormService;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "http://localhost:5173")
public class UserFormController {
	
	@Autowired
	private UserFormService userFormService;
	
	@PostMapping("/save/info")
	public UserForm saveUserInfo(@RequestBody UserForm userForm) {
		return userFormService.saveUserInfo(userForm);
	}
}
