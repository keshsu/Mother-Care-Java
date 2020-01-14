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

import com.mothercare.dto.TblPharmachiesDto;
import com.mothercare.services.PharmaciesServices;

@RestController
@RequestMapping("/pharmachies")
public class PharmachiesController {
	
	@Autowired
	PharmaciesServices pharSer;
	
	
	@PostMapping("/save")
	public TblPharmachiesDto savePharmacies(@RequestBody TblPharmachiesDto patients) {
		return pharSer.savePharmacy(patients);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<TblPharmachiesDto> getPatients(){
		return pharSer.getAllPharmacies();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public TblPharmachiesDto getPharmaciesById(@PathVariable Integer id){
		return pharSer.getPharmacyById(id);
	}
	
	@GetMapping("/delete/{id}")
	public void delPharmacy(@PathVariable Integer id) {
		pharSer.delPharmacy(id);
	}
}
