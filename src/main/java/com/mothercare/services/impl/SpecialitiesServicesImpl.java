package com.mothercare.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mothercare.dto.TblSpecialityDto;
import com.mothercare.entities.TblSpeciality;
import com.mothercare.repository.SpecialityRepository;
import com.mothercare.services.SpecialitiesServices;

@Service
public class SpecialitiesServicesImpl implements SpecialitiesServices{

	@Autowired
	SpecialityRepository speRep;
	
	@Override
	public TblSpecialityDto saveSpecialitie(TblSpecialityDto specialities) {
		TblSpeciality depEntity = TblSpeciality.builder()
				.id(specialities.getId())
				.name(specialities.getName())
				.status(specialities.getStatus())
				.build();
		
		depEntity= speRep.save(depEntity);
		specialities.setId(depEntity.getId());
		
		return specialities;
	}

	@Override
	public List<TblSpecialityDto> getAllSpecialities() {
		List<TblSpeciality> deps = speRep.findAll();
		
		List<TblSpecialityDto> depsDtoList = new ArrayList<>();	
		
		for(TblSpeciality u: deps) {
						
			TblSpecialityDto splt = TblSpecialityDto.builder()
					.id(u.getId())
					.name(u.getName())
					.status(u.getStatus())
					.build();
			
			depsDtoList.add(splt);
		}
		return depsDtoList;
	}

	@Override
	public TblSpecialityDto getSpecialitieById(Integer id) {
		TblSpeciality deps = speRep.findById(id).get();
		
		return TblSpecialityDto.builder()
				.id(deps.getId())
				.name(deps.getName())
				.status(deps.getStatus())
				.build();
	}

	@Override
	public void delSpeciality(Integer id) {
		speRep.deleteById(id);
	}

}
