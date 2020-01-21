package com.mothercare.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mothercare.dto.TblCheckupAssignsDto;
import com.mothercare.entities.TblCheckupAssigns;
import com.mothercare.entities.TblDoctors;
import com.mothercare.entities.TblPatients;
import com.mothercare.entities.TblTreatmentCategory;
import com.mothercare.repository.CheckUpAssignsRepository;
import com.mothercare.services.CheckUpAssignsServices;

@Service
public class CheckupAssignsServicesImpl implements CheckUpAssignsServices{

	@Autowired
	CheckUpAssignsRepository checkupAssignsRep;
	
	@Override
	public void delCheckupAssigns(Integer id) {
		checkupAssignsRep.deleteById(id);
	}

	@Override
	public List<TblCheckupAssignsDto> getAllCheckupAssigns() {
		
		List<TblCheckupAssigns> checkups = checkupAssignsRep.findAll();
		
		List<TblCheckupAssignsDto> checkupsDtoList = new ArrayList<>();		
		for(TblCheckupAssigns u: checkups) {
			
			TblCheckupAssignsDto checkupDto = TblCheckupAssignsDto.builder()
					.id(u.getId())
					.tblDoctors(u.getTblDoctors().getId())
					.tblPatients(u.getTblPatients().getId())
					.tblTreatmentCategory(u.getTblTreatmentCategory().getId()).build();
			
			checkupsDtoList.add(checkupDto);
		}
		return checkupsDtoList;
	}

	@Override
	public TblCheckupAssignsDto getCheckupAssignsById(Integer id) {
		TblCheckupAssigns checkups = checkupAssignsRep.findById(id).get();
		
		return TblCheckupAssignsDto.builder()
				.id(checkups.getId())
				.tblDoctors(checkups.getTblDoctors().getId())
				.tblPatients(checkups.getTblPatients().getId())
				.tblTreatmentCategory(checkups.getTblTreatmentCategory().getId()).build();
	}

	@Override
	public TblCheckupAssignsDto saveCheckupAssigns(TblCheckupAssignsDto checkupAssigns) {
		TblDoctors doc = TblDoctors.builder()
				.id(checkupAssigns.getTblDoctors()).build();
		
		TblPatients pat = TblPatients.builder()
				.id(checkupAssigns.getTblPatients()).build();
		
		TblTreatmentCategory tCat = TblTreatmentCategory.builder()
				.id(checkupAssigns.getTblTreatmentCategory()).build();
		
		TblCheckupAssigns checkupEntity = TblCheckupAssigns.builder()
				.id(checkupAssigns.getId())
				.tblDoctors(doc)
				.tblPatients(pat)
				.tblTreatmentCategory(tCat)
				.build();
		checkupEntity= checkupAssignsRep.save(checkupEntity);
		checkupAssigns.setId(checkupEntity.getId());
		
		return checkupAssigns;
	}

	@Override
	public TblCheckupAssignsDto updateCheckupAssigns(TblCheckupAssignsDto checkupAssigns) {
		
		Optional<TblCheckupAssigns> ch = checkupAssignsRep.findById(checkupAssigns.getId());
		
		if(ch.isPresent()) {
			TblDoctors doc = TblDoctors.builder()
					.id(checkupAssigns.getTblDoctors()).build();
			
			TblPatients pat = TblPatients.builder()
					.id(checkupAssigns.getTblPatients()).build();
			
			TblTreatmentCategory tCat = TblTreatmentCategory.builder()
					.id(checkupAssigns.getTblTreatmentCategory()).build();
			
			TblCheckupAssigns checkupEntity = TblCheckupAssigns.builder()
					.id(checkupAssigns.getId())
					.tblDoctors(doc)
					.tblPatients(pat)
					.tblTreatmentCategory(tCat)
					.build();
			checkupEntity= checkupAssignsRep.save(checkupEntity);
		}
		
		return checkupAssigns;
	}
}
