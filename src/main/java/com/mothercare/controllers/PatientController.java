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

import com.mothercare.dto.TblPatientsDto;
import com.mothercare.services.PatientsServices;

@RestController
@RequestMapping("/patients")
public class PatientController {
	@Autowired
	PatientsServices patSer;
	
	@PostMapping("/save")
	public TblPatientsDto savePatient(@RequestBody TblPatientsDto patients) {
		return patSer.savePatient(patients);
	}

	@PostMapping("/update")
	public TblPatientsDto updatePatient(@RequestBody TblPatientsDto patients) {
		return patSer.updatePatient(patients);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<TblPatientsDto> getPatients(){
		return patSer.getAllPatients();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public TblPatientsDto getpatientsById(@PathVariable Integer id){
		return patSer.getPatientById(id);
	}
	
	@GetMapping("/delete/{id}")
	public void delPatient(@PathVariable Integer id) {
		patSer.delPatient(id);
	}

}
