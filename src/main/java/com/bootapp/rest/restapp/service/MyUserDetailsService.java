package com.bootapp.rest.restapp.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.UserRepository;
import com.bootapp.rest.restapp.model.User;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//go to DB and load the User
		User user = userRepository.getUserByUsername(username);

		Collection<GrantedAuthority> list = new ArrayList<>(); 
		SimpleGrantedAuthority sga = new SimpleGrantedAuthority(user.getRole()); 
		list.add(sga);

		org.springframework.security.core.userdetails.User springUser = new 
				org.springframework.security.core.userdetails.User
				(user.getUsername(),user.getPassword(),list);
		return springUser;
	}




}