package com.mothercare.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mothercare.dto.TblAdminsDto;
import com.mothercare.entities.TblAdmins;
import com.mothercare.repository.AdminRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		TblAdmins userEntity = adminRepo.findByUsername(username);
		if (userEntity == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		} else {
			
			return new User(userEntity.getUsername(), userEntity.getPassword(),
					new ArrayList<>());
		}
	}
	
	public TblAdminsDto save(TblAdminsDto user) {
		TblAdmins userEntity = TblAdmins.builder().username(user.getUsername()).password(passwordEncoder.encode(user.getPassword())).build();
		userEntity = adminRepo.save(userEntity);
		user.setId(userEntity.getId());
		return user;
	}
}
