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
		return "admin/users"; 
		}
	@PostMapping("/saveuser") 
	public String saveUser(User user) {
		System.out.println("Id:"+user.getId()+"***************************");
		System.out.println("Name:"+user.getName()+"***************************");
		System.out.println("pass:"+user.getPassword()+"***************************");
		System.out.println("Active:"+user.getActive()+"***************************");
		System.out.println("ActiveString:"+user.getActiveString()+"***************************");
		user.setPassword(encoder.encode(user.getPassword()));
		user.setActive(user.getActiveString().equalsIgnoreCase("true"));
		userRepository.save(user);
		return "redirect:/listusers";
	}
	@PostMapping("/deleteuser") 
	public String deleteUser(User user) {
		System.out.println(user.getId()+"***********************");
		userRepository.delete(user);
		return "redirect:/listusers";
	}
	
	@PostMapping("/adduser") 
	public String addUser(User user) {
//		userRepository.save(new User(user.getUserName(),user.getPassword(),"ROLE_ADMIN",true));
//		userRepository.save(new User(name,encoder.encode(password),roles,true));
//		userRepository.save(user);
		System.out.println(user.getName()+"**********************************************");
		System.out.println(user.getPassword()+"**********************************************");
		user.setPassword(encoder.encode(user.getPassword()));
		user.setActive(true);
		userRepository.save(new User(user.getName(),user.getPassword(),user.getRoles()));
//		userRepository.delete(user);;
		return "redirect:/listusers";
	}
	
	@GetMapping("/finduser/{id}")
	@ResponseBody
	public  User findLoop(@PathVariable("id")  Long id)  {
		Optional<User> userOpt=userRepository.findById(id);
		User user=userOpt.isEmpty()?null:userOpt.get();
		return user;
	}

}
