package com.mothercare.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mothercare.dto.TblPatientsDto;
import com.mothercare.entities.TblPatients;
import com.mothercare.repository.PatientsRepository;
import com.mothercare.services.PatientsServices;

@Service
public class PatientsServicesImpl implements PatientsServices{

	@Autowired
	PatientsRepository patRepo;

	@Override
	public List<TblPatientsDto> getAllPatients() {
		List<TblPatients> deps = patRepo.findAll();
		
		List<TblPatientsDto> depsDtoList = new ArrayList<>();	
		
		for(TblPatients u: deps) {
						
			TblPatientsDto depDto = TblPatientsDto.builder()
					.id(u.getId())
					.firstname(u.getFirstname())
					.lastname(u.getLastname())
					.pfirstname(u.getPfirstname())
					.plastname(u.getPlastname())
					.email(u.getEmail())
					.contact(u.getContact())
					.pcontact(u.getPcontact())
					.address(u.getAddress())
					.build();
			
			depsDtoList.add(depDto);
		}
		return depsDtoList;
	}

	@Override
	public TblPatientsDto savePatient(TblPatientsDto patients) {
		TblPatients depEntity = TblPatients.builder()
				.id(patients.getId())
				.firstname(patients.getFirstname())
				.lastname(patients.getLastname())
				.pfirstname(patients.getPfirstname())
				.plastname(patients.getPlastname())
				.email(patients.getEmail())
				.password(patients.getPassword())
				.contact(patients.getContact())
				.pcontact(patients.getPcontact())
				.address(patients.getAddress())	
				.build();
		
		depEntity= patRepo.save(depEntity);
		patients.setId(depEntity.getId());
		
		return patients;
	}

	@Override
	public void delPatient(Integer id) {
		patRepo.deleteById(id);
	}

	@Override
	public TblPatientsDto getPatientById(Integer id) {
		TblPatients deps = patRepo.findById(id).get();
		return TblPatientsDto.builder()
				.id(deps.getId())
				.firstname(deps.getFirstname())
				.lastname(deps.getLastname())
				.pfirstname(deps.getPfirstname())
				.plastname(deps.getPlastname())
				.email(deps.getEmail())
				.contact(deps.getContact())
				.pcontact(deps.getPcontact())
				.address(deps.getAddress())	
				.build();
	}

	@Override
	public TblPatientsDto updatePatient(TblPatientsDto patients) {
		Optional<TblPatients> pat = patRepo.findById(patients.getId());
		if(pat.isPresent()) {
			TblPatients depEntity = TblPatients.builder()
					.id(patients.getId())
					.firstname(patients.getFirstname())
					.lastname(patients.getLastname())
					.pfirstname(patients.getPfirstname())
					.plastname(patients.getPlastname())
					.email(patients.getEmail())
					.password(patients.getPassword())
					.contact(patients.getContact())
					.pcontact(patients.getPcontact())
					.address(patients.getAddress())	
					.build();
			
			depEntity= patRepo.save(depEntity);			
		}
		return patients;
	}
}
