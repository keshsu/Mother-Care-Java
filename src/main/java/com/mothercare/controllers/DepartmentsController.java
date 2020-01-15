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

import com.mothercare.dto.TblDepartmentsDto;
import com.mothercare.services.DepartmentsServices;

@RestController
@RequestMapping("/departments")
public class DepartmentsController {
	@Autowired
	DepartmentsServices departmentSer;
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public List<TblDepartmentsDto> getDepartments(){
		return departmentSer.getAllDepartments();	
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public TblDepartmentsDto getCheckupById(@PathVariable Integer id){
		return departmentSer.getDepartmentById(id);
	}
	
	@PostMapping("/save")
	public TblDepartmentsDto savegetDepartments(@RequestBody TblDepartmentsDto getDepartments) {
		return departmentSer.saveDepartments(getDepartments);
	}
	
	@PostMapping("/update")
	public TblDepartmentsDto updateDepartments(@RequestBody TblDepartmentsDto getDepartments) {
		return departmentSer.updateDepartments(getDepartments);
	}
	
	@GetMapping("/delete/{id}")
	public void delgetDepartments(@PathVariable Integer id) {
		departmentSer.delDepartments(id);
	}
}
