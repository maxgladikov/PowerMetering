package com.gladikov.metering.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gladikov.metering.model.User;
import com.gladikov.metering.repo.UserRepository;

@Controller
public class ListUsersController {
	@Autowired
	BCryptPasswordEncoder encoder;
	
	private final UserRepository userRepository;
	@Autowired
	public ListUsersController(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	
	
	
	@GetMapping("/listusers") 
	public String showUserList(Model model) {
		List<User> users=  userRepository.findAll();
		
		model.addAttribute("users", users);
		return "users"; 
		}
	@PostMapping("/saveuser") 
	public String saveUser(User user) {
		System.out.println("Id:"+user.getId()+"***************************");
		
		System.out.println("Active:"+user.getActive()+"***************************");
		System.out.println("ActiveString:"+user.getActiveString()+"***************************");
		System.out.println("Name:"+user.getName()+"***************************");
		//userRepository.save(user);
		return "redirect:/users";
	}
	
	@GetMapping("/finduser/{id}")
	@ResponseBody
	public  User findLoop(@PathVariable("id")  Long id)  {
		Optional<User> userOpt=userRepository.findById(id);
		User user=userOpt.isEmpty()?null:userOpt.get();
		return user;
	}

}
