package com.mothercare.services;

import java.util.List;

import com.mothercare.dto.TblPharmachiesDto;

public interface PharmaciesServices {
	
	public TblPharmachiesDto getPharmacyById(Integer id);

	public TblPharmachiesDto savePharmacy(TblPharmachiesDto pharmas);

	public List<TblPharmachiesDto> getAllPharmacies();

	public void delPharmacy(Integer id);

	public TblPharmachiesDto updatePharmacy(TblPharmachiesDto pharmas);

}
