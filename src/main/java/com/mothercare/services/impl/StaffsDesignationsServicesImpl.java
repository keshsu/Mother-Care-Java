package com.mothercare.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mothercare.dto.TblDesignationsDto;
import com.mothercare.dto.TblStaffsDesignationDto;
import com.mothercare.dto.TblStaffsDto;
import com.mothercare.entities.TblDesignations;
import com.mothercare.entities.TblStaffs;
import com.mothercare.entities.TblStaffsDesignation;
import com.mothercare.repository.StaffDesignationRepository;
import com.mothercare.services.StaffsDesignationsServices;

@Service
public class StaffsDesignationsServicesImpl implements StaffsDesignationsServices
{

	@Autowired
	StaffDesignationRepository stafDRepo;
	
	@Override
	public TblStaffsDesignationDto saveStaff(TblStaffsDesignationDto staffsDesign) {
		TblStaffs stf = TblStaffs.builder()
				.id(staffsDesign.getTblStaffs().getId())
				.firstname(staffsDesign.getTblStaffs().getFirstname())
				.lastname(staffsDesign.getTblStaffs().getLastname())
				.build();
		
		TblDesignations dsg = TblDesignations.builder()
				.id(staffsDesign.getTblDesignations().getId())
				.name(staffsDesign.getTblDesignations().getName())
				.build();
		
		TblStaffsDesignation staffDegEntity= TblStaffsDesignation.builder()
				.id(staffsDesign.getId())
				.tblStaffs(stf)
				.tblDesignations(dsg).build();
		
		staffDegEntity= stafDRepo.save(staffDegEntity);
		staffsDesign.setId(staffsDesign.getId());
		
		return staffsDesign;
	}

	@Override
	public List<TblStaffsDesignationDto> getAllStaffsDesgts() {
		List<TblStaffsDesignation> stafDesg = stafDRepo.findAll();
		
		List<TblStaffsDesignationDto> staffsDtoList = new ArrayList<>();
		
		for(TblStaffsDesignation s: stafDesg) {
			TblStaffsDto stfDto = TblStaffsDto.builder()
					.id(s.getTblStaffs().getId())
					.firstname(s.getTblStaffs().getFirstname())
					.lastname(s.getTblStaffs().getLastname())
					.build();
			
			TblDesignationsDto dsgDto = TblDesignationsDto.builder()
					.id(s.getTblDesignations().getId())
					.name(s.getTblDesignations().getName())
					.build();
			
			TblStaffsDesignationDto staffDto = TblStaffsDesignationDto.builder()
					.id(s.getId())
					.tblStaffs(stfDto)
					.tblDesignations(dsgDto).build();
			
			staffsDtoList.add(staffDto);
		}
		return staffsDtoList;
	}

	@Override
	public TblStaffsDesignationDto getstaffById(Integer id) {
		TblStaffsDesignation deps = stafDRepo.findById(id).get();
		
		TblStaffsDto stf = TblStaffsDto.builder()
				.id(deps.getTblStaffs().getId())
				.firstname(deps.getTblStaffs().getFirstname())
				.lastname(deps.getTblStaffs().getLastname())
				.build();
		
		TblDesignationsDto dsg = TblDesignationsDto.builder()
				.id(deps.getTblDesignations().getId())
				.name(deps.getTblDesignations().getName())
				.build();
		
		return TblStaffsDesignationDto.builder()
				.id(deps.getId())
				.tblStaffs(stf)
				.tblDesignations(dsg).build();
	}

	@Override
	public void delStaffsDesignation(Integer id) {
		stafDRepo.deleteById(id);
	}

}
