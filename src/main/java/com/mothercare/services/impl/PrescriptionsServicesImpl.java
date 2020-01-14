package com.mothercare.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mothercare.dto.TblPrescriptionDto;
import com.mothercare.entities.TblPrescription;
import com.mothercare.repository.PrescriptionRepository;
import com.mothercare.services.PrescriptionsServices;

@Service
public class PrescriptionsServicesImpl implements PrescriptionsServices {

	@Autowired
	PrescriptionRepository preRepo;
	
	@Override
	public TblPrescriptionDto savePrescription(TblPrescriptionDto prescription) {
		TblPrescription prescriptionEntity = TblPrescription.builder()
				.id(prescription.getId())
				.name(prescription.getName())
				.description(prescription.getDescription())
				.comments(prescription.getComments()).build();
		prescriptionEntity= preRepo.save(prescriptionEntity);
		prescription.setId(prescriptionEntity.getId());
		
		return prescription;
	}

	@Override
	public List<TblPrescriptionDto> getAllPrescriptions() {
		List<TblPrescription> prescription = preRepo.findAll();
		
		List<TblPrescriptionDto> prescriptionDtoList = new ArrayList<>();		
		for(TblPrescription u: prescription) {
			TblPrescriptionDto userDto = TblPrescriptionDto.builder()
					.id(u.getId())
					.name(u.getName())
					.description(u.getDescription())
					.comments(u.getComments()).build();
			
			prescriptionDtoList.add(userDto);
		}
		return prescriptionDtoList;
	}

	@Override
	public TblPrescriptionDto getPrescriptionById(Integer id) {
		TblPrescription prescription = preRepo.findById(id).get();
		return TblPrescriptionDto.builder()
				.id(prescription.getId())
				.name(prescription.getName())
				.description(prescription.getDescription())
				.comments(prescription.getComments()).build();
	}

	@Override
	public void delPrescription(Integer id) {
		preRepo.deleteById(id);
	}

}
