package com.mothercare.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mothercare.dto.TblDesignationsDto;
import com.mothercare.entities.TblDesignations;
import com.mothercare.repository.DesignationsRepository;
import com.mothercare.services.DesignationsServices;

@Service
public class DesignationServicesImpl implements DesignationsServices{
	@Autowired
	DesignationsRepository designRepo;
	
	@Override
	public List<TblDesignationsDto> getAllDesignationsDetails() {
		List<TblDesignations> deps = designRepo.findAll();
		
		List<TblDesignationsDto> depsDtoList = new ArrayList<>();	
		
		for(TblDesignations u: deps) {
			
			TblDesignationsDto depDto = TblDesignationsDto.builder()
					.id(u.getId())
					.name(u.getName())
					.status(u.getStatus()).build();
			
			depsDtoList.add(depDto);
		}
		return depsDtoList;
	}

	@Override
	public TblDesignationsDto getDesignationsById(Integer id) {
		TblDesignations deps = designRepo.findById(id).get();
		
		return TblDesignationsDto.builder()
				.id(deps.getId())
				.name(deps.getName())
				.status(deps.getStatus()).build();
	}

	@Override
	public TblDesignationsDto saveDesignation(TblDesignationsDto designation) {
		TblDesignations depEntity = TblDesignations.builder()
				.id(designation.getId())
				.name(designation.getName())
				.status(designation.getStatus())
				.build();
		
		depEntity= designRepo.save(depEntity);
		designation.setId(depEntity.getId());
		
		return designation;
	}

	@Override
	public void delDesignation(Integer id) {
		designRepo.deleteById(id);
	}

}
