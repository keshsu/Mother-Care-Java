package com.mothercare.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mothercare.dto.TblCheckupAssignsDto;
import com.mothercare.dto.TblPharmachiesDto;
import com.mothercare.dto.TblPrescriptionDto;
import com.mothercare.dto.TblSuggestionsDto;
import com.mothercare.entities.TblCheckupAssigns;
import com.mothercare.entities.TblPharmachies;
import com.mothercare.entities.TblPrescription;
import com.mothercare.entities.TblSuggestions;
import com.mothercare.repository.SuggestionsRepository;
import com.mothercare.services.SuggestionsServices;

@Service
public class SuggestionsServicesImpl implements SuggestionsServices{
	
	@Autowired
	SuggestionsRepository sugRep;
	
	@Override
	public TblSuggestionsDto savesuggestion(TblSuggestionsDto suggestions) {
		TblCheckupAssigns checkup = TblCheckupAssigns.builder()
				.id(suggestions.getTblCheckupAssigns().getId()).build();
		
		TblPharmachies pharma= TblPharmachies.builder()
				.id(suggestions.getTblPharmachies().getId()).build();
		
		TblPrescription pres = TblPrescription.builder()
				.id(suggestions.getTblPrescription().getId()).build();
				
		TblSuggestions suggestionEntity = TblSuggestions.builder()
				.id(suggestions.getId())
				.tblCheckupAssigns(checkup)
				.tblPharmachies(pharma)
				.tblPrescription(pres)
				.build();
		suggestionEntity= sugRep.save(suggestionEntity);
		suggestions.setId(suggestionEntity.getId());
		
		return suggestions;
	}

	@Override
	public List<TblSuggestionsDto> getAllsuggestions() {
		List<TblSuggestions> suggs = sugRep.findAll();
		
		List<TblSuggestionsDto> suggestionsDtoList = new ArrayList<>();		
		for(TblSuggestions u: suggs) {
			
			TblCheckupAssignsDto checkDto = TblCheckupAssignsDto.builder()
					.id(u.getTblCheckupAssigns().getId())
					.tblDoctors(u.getTblCheckupAssigns().getTblDoctors().getId())
					.tblPatients(u.getTblCheckupAssigns().getTblDoctors().getId())
					.tblTreatmentCategory(u.getTblCheckupAssigns().getTblDoctors().getId())
					.build();
			
			TblPharmachiesDto pharmaDto= TblPharmachiesDto.builder()
					.id(u.getTblPharmachies().getId())
					.name(u.getTblPharmachies().getName())
					.address(u.getTblPharmachies().getAddress())
					.contact(u.getTblPharmachies().getContact()).build();
			
			TblPrescriptionDto presDto = TblPrescriptionDto.builder()
					.id(u.getTblPrescription().getId())
					.name(u.getTblPrescription().getName())
					.comments(u.getTblPrescription().getComments()).build();
			
			TblSuggestionsDto suggestionsDto = TblSuggestionsDto.builder()
					.id(u.getId())
					.tblCheckupAssigns(checkDto)
					.tblPharmachies(pharmaDto)
					.tblPrescription(presDto)
					.comment(u.getComment()).build();
			
			suggestionsDtoList.add(suggestionsDto);
		}
		return suggestionsDtoList;
	}

	@Override
	public TblSuggestionsDto getSuggestionById(Integer id) {
		
		TblSuggestions suggestions = sugRep.findById(id).get();
		
		TblCheckupAssignsDto checkDto = TblCheckupAssignsDto.builder()
				.id(suggestions.getTblCheckupAssigns().getId())
				.tblDoctors(suggestions.getTblCheckupAssigns().getTblDoctors().getId())
				.tblPatients(suggestions.getTblCheckupAssigns().getTblPatients().getId())
				.tblTreatmentCategory(suggestions.getTblCheckupAssigns().getTblTreatmentCategory().getId())
				.build();
		
		TblPharmachiesDto pharmaDto= TblPharmachiesDto.builder()
				.id(suggestions.getTblPharmachies().getId())
				.name(suggestions.getTblPharmachies().getName())
				.address(suggestions.getTblPharmachies().getAddress())
				.contact(suggestions.getTblPharmachies().getContact()).build();
		
		TblPrescriptionDto presDto = TblPrescriptionDto.builder()
				.id(suggestions.getTblPrescription().getId())
				.name(suggestions.getTblPrescription().getName())
				.comments(suggestions.getTblPrescription().getComments()).build();
		
		return TblSuggestionsDto.builder()
				.id(suggestions.getId())
				.tblCheckupAssigns(checkDto)
				.tblPharmachies(pharmaDto)
				.tblPrescription(presDto)
				.comment(suggestions.getComment()).build();
	}

	@Override
	public void delSuggestion(Integer id) {
		sugRep.deleteById(id);
	}

	@Override
	public TblSuggestionsDto updatesuggestion(TblSuggestionsDto suggestions) {
		Optional<TblSuggestions> sugs = sugRep.findById(suggestions.getId());
		if(sugs.isPresent()) {
			TblCheckupAssigns checkup = TblCheckupAssigns.builder()
					.id(suggestions.getTblCheckupAssigns().getId()).build();
			
			TblPharmachies pharma= TblPharmachies.builder()
					.id(suggestions.getTblPharmachies().getId()).build();
			
			TblPrescription pres = TblPrescription.builder()
					.id(suggestions.getTblPrescription().getId()).build();
					
			TblSuggestions suggestionEntity = TblSuggestions.builder()
					.id(suggestions.getId())
					.tblCheckupAssigns(checkup)
					.tblPharmachies(pharma)
					.tblPrescription(pres)
					.build();
			suggestionEntity= sugRep.save(suggestionEntity);
			suggestions.setId(suggestionEntity.getId());
			
		}
		return suggestions;
	}

}
