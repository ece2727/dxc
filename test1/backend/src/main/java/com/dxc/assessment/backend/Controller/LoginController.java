package com.dxc.assessment.backend.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.assessment.backend.Model.Account;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class LoginController {
	
	@PostMapping(path = "/login")
	public boolean login(@RequestBody Account account) {
		return account.Login();
	}
	
	@GetMapping(path = "/user/{username}")
	public Account getUser(@PathVariable("username") String username) {
		Account account = new Account(username);
		return account.RetrieveAccount();
	}
	
}
