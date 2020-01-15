package com.mothercare.services;

import java.util.List;

import com.mothercare.dto.TblDoctorsDto;


public interface DoctorsServices {
	public List<TblDoctorsDto> getAllDoctors();
	
	public TblDoctorsDto getDoctorById(Integer id);
	
	public TblDoctorsDto saveDoctor(TblDoctorsDto Doctor);
	
	public void delDoctor(Integer id);

	public TblDoctorsDto updateDoctor(TblDoctorsDto user);
}
