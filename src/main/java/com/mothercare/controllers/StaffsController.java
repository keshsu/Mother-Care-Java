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

import com.mothercare.dto.TblStaffsDto;
import com.mothercare.services.StaffsServices;

@RestController
@RequestMapping("/staffs")
public class StaffsController {
	
	@Autowired
	StaffsServices staffSer;
	
	@PostMapping("/save")
	public TblStaffsDto saveStaffs(@RequestBody TblStaffsDto staffs) {
		return staffSer.saveStaff(staffs);
	}

	@PostMapping("/update")
	public TblStaffsDto updateStaffs(@RequestBody TblStaffsDto staffs) {
		return staffSer.updateStaff(staffs);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<TblStaffsDto> getStaffs(){
		return staffSer.getAllStaffs();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public TblStaffsDto getStaffsById(@PathVariable Integer id){
		return staffSer.getstaffById(id);
	}
	
	@GetMapping("/delete/{id}")
	public void delStaff(@PathVariable Integer id) {
		staffSer.delStaff(id);
	}
}
