//package com.bootapp.rest.restapp.controller;
//
//import java.security.Principal;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.bootapp.rest.restapp.data.UserRepository;
//import com.bootapp.rest.restapp.model.User;
//
//@RestController
//@RequestMapping("/api/user")
//public class UserController {
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//
//	
//	@PostMapping("/sign-up")
//	public ResponseEntity<String> signUp(@RequestBody User user) {
//		//check username uniqueness
//		User userDB = userRepository.getUserByUsername(user.getUsername());
//		if(!(userDB == null))
//			return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
//		
//		//Converting plain text password into encoded text
//		String encryptedPassword = passwordEncoder.encode(user.getPassword());
//		user.setPassword(encryptedPassword);
//		userRepository.save(user);
//		return ResponseEntity.status(HttpStatus.OK).body("Signup Success...");
//	}
//	
//	@GetMapping("/login")
//	public void login(Principal principal) {
//		//if u come to this line, it means that username and password are invalid 
//		userRepository.getUserByUsername(principal.getName());
//	}
//	
//	@GetMapping("/hello")
//	public String getHello() {
//		return "Hello";
//	}
//	@GetMapping("/private/hello")
//	public String getAuthHello() {
//		return "Hello Auth";
//	}
//	@GetMapping("private/role/hello")
//	public String getPrivateRoleHello() {
//		return "private role hello";
//	}
//	
//}
