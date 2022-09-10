/**
 * 
 */
package com.gladikov.metering.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gladikov.metering.model.User;
import com.gladikov.metering.repo.UserRepository;

/**
 * @author max
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
//	private final UserRepository userRepository;
//	BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
//	@Autowired
//	public AdminController(UserRepository userRepository) {
//		this.userRepository=userRepository;
//	}
	
	
	
	
//	@PostMapping("/addUser")
//	public String addUser(@RequestBody String name) {
////		userRepository.save(new User(user.getUserName(),user.getPassword(),"ROLE_ADMIN",true));
////		userRepository.save(new User(name,encoder.encode(password),roles,true));
////		userRepository.save(user);
//		System.out.println(name+"**********************************************");
//		return "redirect:/admin";
//	}
	
	
	@PostMapping("/postbody")
    public String postBody(@RequestBody String fullName) {
		System.out.println("***************************");
		System.out.println(fullName);
		System.out.println("****************************");
        return "Hello " + fullName;
    }

}
