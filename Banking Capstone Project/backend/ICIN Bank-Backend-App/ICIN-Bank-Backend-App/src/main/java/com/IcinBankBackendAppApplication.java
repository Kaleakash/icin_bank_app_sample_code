package com;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.icin.entity.Login;
import com.icin.repository.LoginRepository;

@SpringBootApplication(scanBasePackages = "com.icin")// Enable @RestController @Service @Repository 
@EntityScan(basePackages = "com.icin.entity") // enable @Entity 
@EnableJpaRepositories(basePackages = "com.icin.repository") // enable repository 
public class IcinBankBackendAppApplication {

	@Autowired
	LoginRepository loginRepository;
	
	@PostConstruct
	public void init() {
		System.out.println("init method called..");
		Login ll = new Login();
		ll.setEmailid("admin@gmail.com");
		ll.setPassword("admin@123");
		ll.setTypeofuser("admin");
		loginRepository.save(ll);
		System.out.println("Admin account created..");
	}
	public static void main(String[] args) {
		SpringApplication.run(IcinBankBackendAppApplication.class, args);
		System.out.println("spring boot application up!");
	}

}
