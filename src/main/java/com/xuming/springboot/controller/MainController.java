package com.xuming.springboot.controller;

import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xuming.springboot.model.User;
import com.xuming.springboot.repository.UserRepository;

@Controller
@RequestMapping("/demo")
public class MainController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@PostMapping("add")
	public @ResponseBody String addNewUser(@RequestParam String first_name,
			@RequestParam String last_name,
			@RequestParam String email,
			@RequestParam String phone) {
		
		    User n = new User();
		    n.setFirst_name(first_name);
		    n.setLast_name(last_name);
		    n.setEmail(email);
		    n.setPhone(phone);
		    userRepository.save(n);
		    return " Saved !";
		    
		
	}
	
	
	@GetMapping(path="/users")
	public @ResponseBody Iterable<User> getAllUsers(){
		
		return userRepository.findAll();
	}
	

	
	@GetMapping(path="/users/{id}")
	public Optional<User> getUserbyId(@PathVariable(value="id") Integer id) {
		
		Optional<User> user = userRepository.findById(id);
		return user;
		
	}
	
	@GetMapping(path="/amount")
	public @ResponseBody Long getNumber() {
		return userRepository.count();
	}

}
