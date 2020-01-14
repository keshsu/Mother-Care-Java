package com.mothercare.services;

import java.util.List;

import com.mothercare.dto.TblDepartmentsDto;

public interface DepartmentsServices {
	
	public List<TblDepartmentsDto> getAllDepartments();
	
	public TblDepartmentsDto getDepartmentById(Integer id);

	public TblDepartmentsDto saveDepartments(TblDepartmentsDto getDepartments);

	public void delDepartments(Integer id);

}
