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

import com.mothercare.dto.TblSpecialityDto;
import com.mothercare.services.SpecialitiesServices;

@RestController
@RequestMapping("/speciality")
public class SpecialityController {

	@Autowired
	SpecialitiesServices speSer;
	
	@PostMapping("/save")
	public TblSpecialityDto saveSpecialities(@RequestBody TblSpecialityDto Specialities) {
		return speSer.saveSpecialitie(Specialities);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<TblSpecialityDto> getSpecialities(){
		return speSer.getAllSpecialities();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public TblSpecialityDto getSpecialityById(@PathVariable Integer id){
		return speSer.getSpecialitieById(id);
	}
	
	@GetMapping("/delete/{id}")
	public void delSpeciality(@PathVariable Integer id) {
		speSer.delSpeciality(id);
	}
}
