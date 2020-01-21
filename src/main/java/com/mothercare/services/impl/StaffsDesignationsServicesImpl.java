package com.mothercare.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mothercare.dto.TblStaffsDesignationDto;
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
				.id(staffsDesign.getTblStaffs())
				.build();
		
		TblDesignations dsg = TblDesignations.builder()
				.id(staffsDesign.getTblDesignations())
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
			
			TblStaffsDesignationDto staffDto = TblStaffsDesignationDto.builder()
					.id(s.getId())
					.tblStaffs(s.getTblStaffs().getId())
					.tblDesignations(s.getTblDesignations().getId()).build();
			
			staffsDtoList.add(staffDto);
		}
		return staffsDtoList;
	}

	@Override
	public TblStaffsDesignationDto getstaffById(Integer id) {
		TblStaffsDesignation deps = stafDRepo.findById(id).get();

		return TblStaffsDesignationDto.builder()
				.id(deps.getId())
				.tblStaffs(deps.getTblStaffs().getId())
				.tblDesignations(deps.getTblDesignations().getId()).build();
	}

	@Override
	public void delStaffsDesignation(Integer id) {
		stafDRepo.deleteById(id);
	}

	@Override
	public TblStaffsDesignationDto updateStaff(TblStaffsDesignationDto staffsdesgn) {
		Optional<TblStaffsDesignation> staffDe = stafDRepo.findById(staffsdesgn.getId());
		if(staffDe.isPresent()) {
			TblStaffs stf = TblStaffs.builder()
					.id(staffsdesgn.getTblStaffs())
					.build();
			
			TblDesignations dsg = TblDesignations.builder()
					.id(staffsdesgn.getTblDesignations())
					.build();
			
			TblStaffsDesignation staffDegEntity= TblStaffsDesignation.builder()
					.id(staffsdesgn.getId())
					.tblStaffs(stf)
					.tblDesignations(dsg).build();
			
			staffDegEntity= stafDRepo.save(staffDegEntity);
			staffsdesgn.setId(staffsdesgn.getId());
			
		}
		return staffsdesgn;
	}

}
