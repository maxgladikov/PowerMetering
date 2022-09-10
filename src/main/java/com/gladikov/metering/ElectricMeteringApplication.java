package com.gladikov.metering;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gladikov.metering.model.User;
import com.gladikov.metering.repo.UserRepository;

@SpringBootApplication
public class ElectricMeteringApplication implements CommandLineRunner{
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(ElectricMeteringApplication.class, args);
	
	}

	@Override
	public void run(String... args) throws Exception {
//		userRepository.save(new User("max",encoder.encode("pass"),"ROLE_ADMIN",true));
	}

}
