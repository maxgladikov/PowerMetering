package com.gladikov.metering.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gladikov.metering.model.User;
import com.gladikov.metering.repo.UserRepository;

@Controller
@RequestMapping("/adduser")
public class AddUserController {
	
	private final UserRepository userRepository;
	@Autowired
	BCryptPasswordEncoder encoder;
	@Autowired
	public AddUserController(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	
	
	@GetMapping
	public String showForm(Model model) {
		
		model.addAttribute("user",new User());
		
		return "addUser";
	}
	
	
	@PostMapping
	public String addUser(User user) {
//		userRepository.save(new User(user.getUserName(),user.getPassword(),"ROLE_ADMIN",true));
//		userRepository.save(new User(name,encoder.encode(password),roles,true));
//		userRepository.save(user);
		System.out.println(user.getName()+"**********************************************");
		System.out.println(user.getPassword()+"**********************************************");
		user.setPassword(encoder.encode(user.getPassword()));
		user.setActive(true);
		userRepository.save(user);
//		userRepository.delete(user);;
		return "redirect:/listusers";
	}
	
	

}
