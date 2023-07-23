package com.icin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icin.entity.Account;
import com.icin.entity.Login;
import com.icin.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
	AccountService accountService;
	
	public String signIn(Login login) {
		Optional<Login> result	= loginRepository.findById(login.getEmailid());
		
		if(result.isPresent()) {
			Login ll = result.get(); 
			
			if(ll.getPassword().equals(login.getPassword())) {
					
					if(ll.getTypeofuser().equals("admin") && login.getTypeofuser().equals("admin")) {
						return "Admin success";
					}else {
						return "Customer success";
					}
					
			}else {
				return "Invalid Password";
			}
		}else {
			return "InValid emailid";
		}
		
	}
	
	
	public String signUp(Login login) {
		Optional<Login> result	= loginRepository.findById(login.getEmailid());
		if(result.isPresent()) {
				return "Account already exists";
		}else if(login.getTypeofuser().equals("admin")){
				return "Admin account can't create";
		}else {
			loginRepository.save(login);
			
			Account acc = new Account();		// accno is auto increment 
			acc.setEmailid(login.getEmailid());
			acc.setTypeofaccount("saving");
			acc.setAmount(10000);
			accountService.createAccount(acc);
			return "Account created successfully";
		}		
		
	}
}
