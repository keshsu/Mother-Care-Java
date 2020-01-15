package com.mothercare.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mothercare.dto.TblPharmachiesDto;
import com.mothercare.entities.TblPharmachies;
import com.mothercare.repository.PharmaciesRepository;
import com.mothercare.services.PharmaciesServices;

@Service
public class PharmaciesServicesImpl implements PharmaciesServices{

	@Autowired
	PharmaciesRepository pharmaciesRepo;

	@Override
	public TblPharmachiesDto savePharmacy(TblPharmachiesDto pharmacies) {
		TblPharmachies pharmaciesEntity= TblPharmachies.builder()
				.id(pharmacies.getId())
				.name(pharmacies.getName())
				.email(pharmacies.getEmail())
				.password(pharmacies.getPassword())
				.contact(pharmacies.getContact())
				.address(pharmacies.getAddress())
				.status(pharmacies.getStatus())
				.build();
		
		pharmaciesEntity= pharmaciesRepo.save(pharmaciesEntity);
		pharmacies.setId(pharmacies.getId());
		
		return pharmacies;
	}

	@Override
	public List<TblPharmachiesDto> getAllPharmacies() {
		List<TblPharmachies> deps = pharmaciesRepo.findAll();
		
		List<TblPharmachiesDto> depsDtoList = new ArrayList<>();	
		
		for(TblPharmachies u: deps) {
						
			TblPharmachiesDto depDto = TblPharmachiesDto.builder()
					.id(u.getId())
					.name(u.getName())
					.email(u.getEmail())
					.password(u.getPassword())
					.contact(u.getContact())
					.address(u.getAddress())
					.status(u.getStatus())
					.build();
			
			depsDtoList.add(depDto);
		}
		return depsDtoList;
	}

	@Override
	public void delPharmacy(Integer id) {
		pharmaciesRepo.deleteById(id);
	}

	@Override
	public TblPharmachiesDto getPharmacyById(Integer id) {
		TblPharmachies deps = pharmaciesRepo.findById(id).get();
		return TblPharmachiesDto.builder()
				.name(deps.getName())
				.email(deps.getEmail())
				.password(deps.getPassword())
				.contact(deps.getContact())
				.address(deps.getAddress())
				.status(deps.getStatus())
				.build();
		}

	@Override
	public TblPharmachiesDto updatePharmacy(TblPharmachiesDto pharmas) {
		Optional<TblPharmachies> pharma = pharmaciesRepo.findById(pharmas.getId());
		if(pharma.isPresent()) {
			TblPharmachies pharmaciesEntity= TblPharmachies.builder()
					.id(pharmas.getId())
					.name(pharmas.getName())
					.email(pharmas.getEmail())
					.password(pharmas.getPassword())
					.contact(pharmas.getContact())
					.address(pharmas.getAddress())
					.status(pharmas.getStatus())
					.build();
			
			pharmaciesEntity= pharmaciesRepo.save(pharmaciesEntity);
			
		}
		return pharmas;
	}
}