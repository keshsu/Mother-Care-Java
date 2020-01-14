package com.mothercare.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mothercare.dto.TblDoctorsDto;
import com.mothercare.dto.TblSpecialityDto;
import com.mothercare.entities.TblDoctors;
import com.mothercare.entities.TblSpeciality;
import com.mothercare.repository.DoctorsRepository;
import com.mothercare.services.DoctorsServices;

@Service
public class DoctorsServicesImpl implements DoctorsServices {

	@Autowired
	DoctorsRepository  docRepo;

	
	@Override
	public List<TblDoctorsDto> getAllDoctors() {
		List<TblDoctors> deps = docRepo.findAll();
		
		List<TblDoctorsDto> depsDtoList = new ArrayList<>();	
		
		for(TblDoctors u: deps) {
						
			TblSpecialityDto splt = TblSpecialityDto.builder()
					.id(u.getTblSpeciality().getId())
					.name(u.getTblSpeciality().getName())
					.build();
			
			TblDoctorsDto depDto = TblDoctorsDto.builder()
					.id(u.getId())
					.firstname(u.getFirstname())
					.lastname(u.getLastname())
					.email(u.getEmail())
					.contact(u.getContact())
					.tblSpeciality(splt)
					.qualification(u.getQualification())
					.address(u.getAddress())
					.build();
			
			depsDtoList.add(depDto);
		}
		return depsDtoList;
	}

	@Override
	public TblDoctorsDto getDoctorById(Integer id) {
		TblDoctors deps = docRepo.findById(id).get();
		
		TblSpecialityDto splt = TblSpecialityDto.builder()
				.id(deps.getTblSpeciality().getId())
				.name(deps.getTblSpeciality().getName())
				.build();
		
		return TblDoctorsDto.builder()
				.id(deps.getId())
				.firstname(deps.getFirstname())
				.lastname(deps.getLastname())
				.email(deps.getEmail())
				.contact(deps.getContact())
				.tblSpeciality(splt)
				.qualification(deps.getQualification())
				.address(deps.getAddress())
				.build();
	}
	
	@Override
	public TblDoctorsDto saveDoctor(TblDoctorsDto DoctorsDto) {
		TblSpeciality splt = TblSpeciality.builder()
				.id(DoctorsDto.getTblSpeciality().getId()).build();
		
		TblDoctors depEntity = TblDoctors.builder()
				.id(DoctorsDto.getId())
				.firstname(DoctorsDto.getFirstname())
				.lastname(DoctorsDto.getLastname())
				.email(DoctorsDto.getEmail())
				.password(DoctorsDto.getPassword())
				.contact(DoctorsDto.getContact())
				.tblSpeciality(splt)
				.qualification(DoctorsDto.getQualification())
				.address(DoctorsDto.getAddress())
				.build();
		
		depEntity= docRepo.save(depEntity);
		DoctorsDto.setId(depEntity.getId());
		
		return DoctorsDto;
	}
	@Override
	public void delDoctor(Integer id) {
		docRepo.deleteById(id);
	}

}
