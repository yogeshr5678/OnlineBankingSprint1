//package com.bootapp.rest.restapp;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import com.bootapp.rest.restapp.service.MyUserDetailsService;
//
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	private MyUserDetailsService myUserDetailsService;
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		
//	auth.authenticationProvider(getAuthProvider());
//	
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		//I will define API URLS that need security
//		http.authorizeRequests()
//		.antMatchers(HttpMethod.GET,"/api/user/login").authenticated()
//		.antMatchers(HttpMethod.GET,"/api/user/").permitAll()
//		.antMatchers(HttpMethod.GET,"/api/user/private").authenticated()
//		.antMatchers(HttpMethod.GET,"/api/").hasAnyAuthority("","")
//		.anyRequest().permitAll()
//		.and().httpBasic().and().csrf().disable();
//	
//	
//	}
//	
//	private DaoAuthenticationProvider getAuthProvider(){
//		//I will take spring to my DB for loading the users.
//		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
//		//1.Password encoder
//		dao.setPasswordEncoder(getPasswordEncoder());
//		//2. Take dao to service class that will load the user from DB
//		dao.setUserDetailsService(myUserDetailsService);
//		return dao;
//	}
//	
//	@Bean
//	PasswordEncoder getPasswordEncoder(){//To use passwordEncoder in our app we must define this method as Bean method
//		PasswordEncoder encoder = new BCryptPasswordEncoder();
//		return encoder;
//	}
//	
//	
//}
