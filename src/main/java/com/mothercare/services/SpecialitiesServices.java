package com.mothercare.services;

import java.util.List;

import com.mothercare.dto.TblSpecialityDto;

public interface SpecialitiesServices {

	public TblSpecialityDto saveSpecialitie(TblSpecialityDto specialities);

	public List<TblSpecialityDto> getAllSpecialities();

	public TblSpecialityDto getSpecialitieById(Integer id);

	public void delSpeciality(Integer id);

	public TblSpecialityDto updateSpecialitie(TblSpecialityDto specialities);

}
