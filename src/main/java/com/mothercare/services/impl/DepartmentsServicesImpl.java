package com.mothercare.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mothercare.dto.TblDepartmentsDto;
import com.mothercare.entities.TblDepartments;
import com.mothercare.repository.DepartmentsRepository;
import com.mothercare.services.DepartmentsServices;

@Service
public class DepartmentsServicesImpl implements DepartmentsServices{
	
	@Autowired
	DepartmentsRepository departmentRepo;
	
	@Override
	public List<TblDepartmentsDto> getAllDepartments() {
		List<TblDepartments> deps = departmentRepo.findAll();
		
		List<TblDepartmentsDto> depsDtoList = new ArrayList<>();	
		
		for(TblDepartments u: deps) {
			
			TblDepartmentsDto depDto = TblDepartmentsDto.builder()
					.id(u.getId())
					.name(u.getName())
					.status(u.getStatus()).build();
			
			depsDtoList.add(depDto);
		}
		return depsDtoList;
	}

	@Override
	public TblDepartmentsDto getDepartmentById(Integer id) {
		TblDepartments department = departmentRepo.findById(id).get();

		return TblDepartmentsDto.builder()
				.id(department.getId())
				.name(department.getName())
				.status(department.getStatus()).build();
	}
	
	@Override
	public TblDepartmentsDto saveDepartments(TblDepartmentsDto departmentsDto) {
		TblDepartments depEntity = TblDepartments.builder()
				.id(departmentsDto.getId())
				.name(departmentsDto.getName())
				.status(departmentsDto.getStatus())
				.build();
		
		depEntity= departmentRepo.save(depEntity);
		departmentsDto.setId(depEntity.getId());
		
		return departmentsDto;
	}

	@Override
	public void delDepartments(Integer id) {
		departmentRepo.deleteById(id);
	}
}
