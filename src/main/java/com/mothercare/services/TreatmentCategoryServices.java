package com.mothercare.services;

import java.util.List;

import com.mothercare.dto.TblTreatmentCategoryDto;

public interface TreatmentCategoryServices {

	public TblTreatmentCategoryDto savetreatmentCat(TblTreatmentCategoryDto treatmentCats);

	public TblTreatmentCategoryDto gettreatmentCatById(Integer id);

	void deltreatmentCat(Integer id);

	public TblTreatmentCategoryDto updatetreatmentCat(TblTreatmentCategoryDto treatmentCats);

	public List<TblTreatmentCategoryDto> getAlltreatmentCategories();
}
