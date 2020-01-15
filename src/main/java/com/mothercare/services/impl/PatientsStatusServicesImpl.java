package com.mothercare.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mothercare.dto.TblPatientsDto;
import com.mothercare.dto.TblPatientsStatusDto;
import com.mothercare.entities.TblPatientStatus;
import com.mothercare.entities.TblPatients;
import com.mothercare.repository.PatientsStatusRepository;
import com.mothercare.services.PatientsStatusServices;

@Service
public class PatientsStatusServicesImpl implements PatientsStatusServices{

	@Autowired
	PatientsStatusRepository patRepo;
	
	@Override
	public TblPatientsStatusDto savePatientStatus(TblPatientsStatusDto pats) {
		TblPatients patients = TblPatients.builder()
				.id(pats.getTblPatients().getId()).build();
		
		TblPatientStatus patStEntity = TblPatientStatus.builder()
				.id(pats.getId())
				.tblPatients(patients)
				.featured(pats.getFeatured())
				.status(pats.getStatus()).build();
		
		patStEntity= patRepo.save(patStEntity);
		pats.setId(patStEntity.getId());
		
		return pats;
	}

	@Override
	public List<TblPatientsStatusDto> getAllPatientStatuss() {
		List<TblPatientStatus> pats = patRepo.findAll();
		
		List<TblPatientsStatusDto> patsDtoList = new ArrayList<>();		
		for(TblPatientStatus u: pats) {
			TblPatientsDto patients = TblPatientsDto.builder()
					.id(u.getTblPatients().getId())
					.firstname(u.getTblPatients().getFirstname())
					.lastname(u.getTblPatients().getLastname()).build();
			TblPatientsStatusDto patDto = TblPatientsStatusDto.builder()
					.id(u.getId())
					.tblPatients(patients)
					.featured(u.getFeatured())
					.status(u.getStatus()).build();
			
			patsDtoList.add(patDto);
		}
		return patsDtoList;
	}

	@Override
	public TblPatientsStatusDto getPatientStatusById(Integer id) {
		TblPatientStatus pats = patRepo.findById(id).get();
		
		TblPatientsDto patients = TblPatientsDto.builder()
				.id(pats.getTblPatients().getId())
				.firstname(pats.getTblPatients().getFirstname())
				.lastname(pats.getTblPatients().getLastname()).build();
		
		return  TblPatientsStatusDto.builder()
				.id(pats.getId())
				.tblPatients(patients)
				.featured(pats.getFeatured())
				.status(pats.getStatus()).build();
	}

	@Override
	public void delPatientStatus(Integer id) {
		patRepo.deleteById(id);
	}

	@Override
	public TblPatientsStatusDto updatePatientStatus(TblPatientsStatusDto pats) {
		Optional<TblPatientStatus> patstatus = patRepo.findById(pats.getId());
		if(patstatus.isPresent()) {
			TblPatients patients = TblPatients.builder()
					.id(pats.getTblPatients().getId()).build();
			
			TblPatientStatus patStEntity = TblPatientStatus.builder()
					.id(pats.getId())
					.tblPatients(patients)
					.featured(pats.getFeatured())
					.status(pats.getStatus()).build();
			
			patStEntity= patRepo.save(patStEntity);
			
		}
		return pats;
	}

}
