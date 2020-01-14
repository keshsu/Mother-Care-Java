package com.mothercare.services;

import java.util.List;

import com.mothercare.dto.TblPatientsDto;

public interface PatientsServices {
	
	public List<TblPatientsDto> getAllPatients();

	public TblPatientsDto savePatient(TblPatientsDto patients);

	public void delPatient(Integer id);

	public TblPatientsDto getPatientById(Integer id);

}
