package com.mothercare.services;

import java.util.List;

import com.mothercare.dto.TblPatientsStatusDto;

public interface PatientsStatusServices {

	public TblPatientsStatusDto savePatientStatus(TblPatientsStatusDto pats);

	public List<TblPatientsStatusDto> getAllPatientStatuss();

	public TblPatientsStatusDto getPatientStatusById(Integer id);

	public void delPatientStatus(Integer id);

	public TblPatientsStatusDto updatePatientStatus(TblPatientsStatusDto pats);
	
}	
