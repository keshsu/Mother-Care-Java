package com.mothercare.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mothercare.dto.TblCheckupAssignsDto;
import com.mothercare.dto.TblDoctorsDto;
import com.mothercare.dto.TblPatientsDto;
import com.mothercare.dto.TblTreatmentCategoryDto;
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
			TblDoctorsDto docDto = TblDoctorsDto.builder()
					.id(u.getTblDoctors().getId())
					.firstname(u.getTblDoctors().getFirstname())
					.lastname(u.getTblDoctors().getLastname())
					.build();
			
			TblPatientsDto patDto = TblPatientsDto.builder()
					.id(u.getTblPatients().getId())
					.firstname(u.getTblPatients().getFirstname())
					.lastname(u.getTblPatients().getLastname())
					.build();
			TblTreatmentCategoryDto terDto = TblTreatmentCategoryDto.builder()
					.id(u.getTblTreatmentCategory().getId())
					.name(u.getTblTreatmentCategory().getName()).build();
			
			TblCheckupAssignsDto checkupDto = TblCheckupAssignsDto.builder()
					.id(u.getId())
					.tblDoctors(docDto)
					.tblPatients(patDto)
					.tblTreatmentCategory(terDto).build();
			
			checkupsDtoList.add(checkupDto);
		}
		return checkupsDtoList;
	}

	@Override
	public TblCheckupAssignsDto getCheckupAssignsById(Integer id) {
		TblCheckupAssigns checkups = checkupAssignsRep.findById(id).get();
		TblDoctorsDto docDto = TblDoctorsDto.builder()
				.id(checkups.getTblDoctors().getId())
				.firstname(checkups.getTblDoctors().getFirstname())
				.lastname(checkups.getTblDoctors().getLastname())
				.build();
		
		TblPatientsDto patDto = TblPatientsDto.builder()
				.id(checkups.getTblPatients().getId())
				.firstname(checkups.getTblPatients().getFirstname())
				.lastname(checkups.getTblPatients().getLastname())
				.build();
		TblTreatmentCategoryDto terDto = TblTreatmentCategoryDto.builder()
				.id(checkups.getTblTreatmentCategory().getId())
				.name(checkups.getTblTreatmentCategory().getName()).build();
		
		return TblCheckupAssignsDto.builder()
				.id(checkups.getId())
				.tblDoctors(docDto)
				.tblPatients(patDto)
				.tblTreatmentCategory(terDto).build();
	}

	@Override
	public TblCheckupAssignsDto saveCheckupAssigns(TblCheckupAssignsDto checkupAssigns) {
		TblDoctors doc = TblDoctors.builder()
				.id(checkupAssigns.getTblDoctors().getId()).build();
		
		TblPatients pat = TblPatients.builder()
				.id(checkupAssigns.getTblPatients().getId()).build();
		
		TblTreatmentCategory tCat = TblTreatmentCategory.builder()
				.id(checkupAssigns.getTblTreatmentCategory().getId()).build();
		
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

}
