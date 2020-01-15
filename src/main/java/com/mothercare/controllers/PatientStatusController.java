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

import com.mothercare.dto.TblPatientsStatusDto;
import com.mothercare.services.PatientsStatusServices;

@RestController
@RequestMapping("/patient-status")
public class PatientStatusController {
	@Autowired
	PatientsStatusServices patSer;
	
	@PostMapping("/save")
	public TblPatientsStatusDto savePatientStatus(@RequestBody TblPatientsStatusDto pats) {
		return patSer.savePatientStatus(pats);
	}
	
	@PostMapping("/update")
	public TblPatientsStatusDto updatePatientStatus(@RequestBody TblPatientsStatusDto pats) {
		return patSer.updatePatientStatus(pats);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<TblPatientsStatusDto> getUsers(){
		return patSer.getAllPatientStatuss();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public TblPatientsStatusDto getUserById(@PathVariable Integer id){
		return patSer.getPatientStatusById(id);
	}
	
	@GetMapping("/delete/{id}")
	public void delPatientStatus(@PathVariable Integer id) {
		patSer.delPatientStatus(id);
	}
}
