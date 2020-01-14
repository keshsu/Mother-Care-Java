package com.mothercare.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mothercare.dto.TblAdminsDto;
import com.mothercare.services.AdminServices;

@RestController
@RequestMapping("/admins")
public class AdminsController {
	
	@Autowired
	AdminServices adminSer;

	
	@PostMapping("/save")
	public TblAdminsDto saveUser(@RequestBody TblAdminsDto user) {
		return adminSer.saveUser(user);
	}
	
	@PostMapping("/update")
	public TblAdminsDto updateUser(@RequestBody TblAdminsDto user) {
		return adminSer.updateUser(user);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<TblAdminsDto> getUsers(){
		return adminSer.getAllUsersDetails();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public TblAdminsDto getUserById(@PathVariable Integer id){
		return adminSer.getUsersById(id);
	}
	
	@GetMapping("/delete/{id}")
	public void delUser(@PathVariable Integer id) {
		adminSer.delUser(id);
	}
}
