package com.mothercare.services;

import java.util.List;

import com.mothercare.dto.TblAdminsDto;


public interface AdminServices {
	public List<TblAdminsDto> getAllUsersDetails();
	
	public TblAdminsDto getUsersById(Integer id);
	
	public TblAdminsDto saveUser(TblAdminsDto user);
	
	public void delUser(Integer id);

	public TblAdminsDto updateUser(TblAdminsDto user);
	
}	
	