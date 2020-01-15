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

import com.mothercare.dto.TblDoctorsDto;
import com.mothercare.services.DoctorsServices;

@RestController
@RequestMapping("/doctors")
public class DoctorsController {
	
	@Autowired
	DoctorsServices docSer;
	
	@PostMapping("/save")
	public TblDoctorsDto saveDoctor(@RequestBody TblDoctorsDto user) {
		return docSer.saveDoctor(user);
	}

	@PostMapping("/update")
	public TblDoctorsDto updateDoctor(@RequestBody TblDoctorsDto user) {
		return docSer.updateDoctor(user);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<TblDoctorsDto> getUsers(){
		return docSer.getAllDoctors();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public TblDoctorsDto getUserById(@PathVariable Integer id){
		return docSer.getDoctorById(id);
	}
	
	@GetMapping("/delete/{id}")
	public void delDoctor(@PathVariable Integer id) {
		docSer.delDoctor(id);
	}
}
