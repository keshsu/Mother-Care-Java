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

import com.mothercare.dto.TblStaffsDesignationDto;
import com.mothercare.services.StaffsDesignationsServices;

@RestController
@RequestMapping("/staffs-designation")
public class StaffsDesignationsController {
	
	@Autowired
	StaffsDesignationsServices staffDSer;
	
	@PostMapping("/save")
	public TblStaffsDesignationDto saveStaffs(@RequestBody TblStaffsDesignationDto staffsdesgn) {
		return staffDSer.saveStaff(staffsdesgn);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<TblStaffsDesignationDto> getStaffsDesgts(){
		return staffDSer.getAllStaffsDesgts();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public TblStaffsDesignationDto getStaffsDsignationById(@PathVariable Integer id){
		return staffDSer.getstaffById(id);
	}
	
	
	@GetMapping("/delete/{id}")
	public void delStaffsDesignation(@PathVariable Integer id) {
		staffDSer.delStaffsDesignation(id);
	}
}
