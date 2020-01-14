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

import com.mothercare.dto.TblDesignationsDto;
import com.mothercare.services.DesignationsServices;

@RestController
@RequestMapping("/designations")
public class DesignationsController {
	
	@Autowired
	DesignationsServices desigSer;

	
	@PostMapping("/save")
	public TblDesignationsDto saveDesignation(@RequestBody TblDesignationsDto Designation) {
		return desigSer.saveDesignation(Designation);
	}
	
	@PostMapping("/update")
	public TblDesignationsDto updateDesignation(@RequestBody TblDesignationsDto Designation) {
		return desigSer.supdateDesignation(Designation);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<TblDesignationsDto> getDesignations(){
		return desigSer.getAllDesignationsDetails();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public TblDesignationsDto getDesignationById(@PathVariable Integer id){
		return desigSer.getDesignationsById(id);
	}
	
	@GetMapping("/delete/{id}")
	public void delDesignation(@PathVariable Integer id) {
		desigSer.delDesignation(id);
	}
}
