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

import com.mothercare.dto.TblPrescriptionDto;
import com.mothercare.services.PrescriptionsServices;

@RestController
@RequestMapping("/prescription")
public class PerscriptionsController {
	
	@Autowired 
	PrescriptionsServices prsSer;
	
	@PostMapping("/save")
	public TblPrescriptionDto savePrescriptions(@RequestBody TblPrescriptionDto prescription) {
		return prsSer.savePrescription(prescription);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<TblPrescriptionDto> getPatients(){
		return prsSer.getAllPrescriptions();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public TblPrescriptionDto getPrescriptionById(@PathVariable Integer id){
		return prsSer.getPrescriptionById(id);
	}
	
	@GetMapping("/delete/{id}")
	public void delPrescription(@PathVariable Integer id) {
		prsSer.delPrescription(id);
	}
}
