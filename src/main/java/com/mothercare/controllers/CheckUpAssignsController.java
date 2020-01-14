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

import com.mothercare.dto.TblCheckupAssignsDto;
import com.mothercare.services.CheckUpAssignsServices;

@RestController
@RequestMapping("/Checkups")
public class CheckUpAssignsController {
	
	@Autowired
	CheckUpAssignsServices checkupAssignsSer;
	
	@RequestMapping(value = "/list", method= RequestMethod.GET)
	public List<TblCheckupAssignsDto> getCheckupAssigns(){
		return checkupAssignsSer.getAllCheckupAssigns();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public TblCheckupAssignsDto getCheckupById(@PathVariable Integer id){
		return checkupAssignsSer.getCheckupAssignsById(id);
	}
	
	@PostMapping("/save")
	public TblCheckupAssignsDto saveCheckupAssigns(@RequestBody TblCheckupAssignsDto CheckupAssigns) {
		return checkupAssignsSer.saveCheckupAssigns(CheckupAssigns);
	}
	
	@GetMapping("/delete/{id}")
	public void delCheckupAssigns(@PathVariable Integer id) {
		checkupAssignsSer.delCheckupAssigns(id);
	}
}
