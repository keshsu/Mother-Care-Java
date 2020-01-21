package com.mothercare.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mothercare.dto.TblTreatmentCategoryDto;
import com.mothercare.entities.TblTreatmentCategory;
import com.mothercare.repository.TreatmentCategoryRepository;
import com.mothercare.services.TreatmentCategoryServices;

@Service
public class TreatmentCategoryImpl implements TreatmentCategoryServices{
	@Autowired
	TreatmentCategoryRepository treatCatRep;

	@Override
	public List<TblTreatmentCategoryDto> getAlltreatmentCategories() {
		List<TblTreatmentCategory> tblCat = treatCatRep.findAll();
		
		List<TblTreatmentCategoryDto> tblCatDtoList = new ArrayList<>();
		
		for(TblTreatmentCategory t: tblCat) {
			
			TblTreatmentCategoryDto treatDto = TblTreatmentCategoryDto.builder()
			.id(t.getId())
			.name(t.getName())
			.status(t.getStatus()).build();
			
			tblCatDtoList.add(treatDto);
		}
		return tblCatDtoList;
	}

	@Override
	public TblTreatmentCategoryDto savetreatmentCat(TblTreatmentCategoryDto treatmentCats) {
		TblTreatmentCategory treatEntity= TblTreatmentCategory.builder()
				.name(treatmentCats.getName())
				.status(treatmentCats.getStatus()).build();
		
		treatEntity= treatCatRep.save(treatEntity);
		treatmentCats.setId(treatmentCats.getId());
		
		return treatmentCats;
	}

	@Override
	public TblTreatmentCategoryDto gettreatmentCatById(Integer id) {
		TblTreatmentCategory treatCat = treatCatRep.findById(id).get();
		return TblTreatmentCategoryDto.builder()
				.id(treatCat.getId())
				.name(treatCat.getName())
				.status(treatCat.getStatus()).build();
	}

	@Override
	public void deltreatmentCat(Integer id) {
		treatCatRep.deleteById(id);
	}

	@Override
	public TblTreatmentCategoryDto updatetreatmentCat(TblTreatmentCategoryDto treatmentCats) {
		Optional<TblTreatmentCategory> treatCat = treatCatRep.findById(treatmentCats.getId());
		if(treatCat.isPresent()) {
			TblTreatmentCategory treatEntity= TblTreatmentCategory.builder()
					.name(treatmentCats.getName())
					.status(treatmentCats.getStatus()).build();
			
			treatEntity= treatCatRep.save(treatEntity);
			
		}
		return treatmentCats;
	}

}
