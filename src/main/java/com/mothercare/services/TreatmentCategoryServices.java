package com.mothercare.services;

import java.util.List;

import com.mothercare.dto.TblTreatmentCategoryDto;

public interface TreatmentCategoryServices {

	public TblTreatmentCategoryDto savetreatmentCat(TblTreatmentCategoryDto treatmentCats);

	public List<TblTreatmentCategoryDto> getAlltreatmentCats();

	public TblTreatmentCategoryDto gettreatmentCatById(Integer id);

	void deltreatmentCat(Integer id);

}
