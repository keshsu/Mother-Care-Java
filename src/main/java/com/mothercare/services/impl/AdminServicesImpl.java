package com.mothercare.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mothercare.dto.TblAdminsDto;
import com.mothercare.entities.TblAdmins;
import com.mothercare.repository.AdminRepository;
import com.mothercare.services.AdminServices;

@Service
public class AdminServicesImpl implements AdminServices{

	@Autowired
	AdminRepository userRepo;
	
	@Override
	public List<TblAdminsDto> getAllUsersDetails() {
		List<TblAdmins> users = userRepo.findAll();
		
		List<TblAdminsDto> usersDtoList = new ArrayList<>();		
		for(TblAdmins u: users) {
			TblAdminsDto userDto = TblAdminsDto.builder()
					.id(u.getId())
					.username(u.getUsername()).build();
			
			usersDtoList.add(userDto);
		}
		return usersDtoList;
	}

	@Override
	public TblAdminsDto getUsersById(Integer id) {
		TblAdmins users = userRepo.findById(id).get();
		return TblAdminsDto.builder()
				.id(users.getId())
				.username(users.getUsername()).build();
	}

	@Override
	public TblAdminsDto saveUser(TblAdminsDto user) {
		TblAdmins adminEntity = TblAdmins.builder()
				.username(user.getUsername())
				.password(user.getPassword()).build();
		adminEntity= userRepo.save(adminEntity);
		user.setId(adminEntity.getId());
		
		return user;
	}

	@Override
	public void delUser(Integer id) {
		userRepo.deleteById(id);
	}
}
	
//gradle build -x test
