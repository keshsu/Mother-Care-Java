package com.mothercare.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mothercare.dto.TblStaffsDto;
import com.mothercare.entities.TblStaffs;
import com.mothercare.repository.StaffRepository;
import com.mothercare.services.StaffsServices;

@Service
public class StaffsServiceImpl implements StaffsServices{
	
	@Autowired
	StaffRepository staffRepo;

	@Override
	public TblStaffsDto saveStaff(TblStaffsDto staffs) {
		TblStaffs staffEntity= TblStaffs.builder()
				.firstname(staffs.getFirstname())
				.lastname(staffs.getLastname())
				.username(staffs.getUsername())
				.email(staffs.getEmail())
				.contact(staffs.getContact())
				.address(staffs.getAddress())
				.status(staffs.getStatus()).build();
		
		staffEntity= staffRepo.save(staffEntity);
		staffs.setId(staffs.getId());
		
		return staffs;
	}

	@Override
	public TblStaffsDto getstaffById(Integer id) {
		TblStaffs deps = staffRepo.findById(id).get();
		return TblStaffsDto.builder()
				.id(deps.getId())
				.firstname(deps.getFirstname())
				.lastname(deps.getLastname())
				.username(deps.getUsername())
				.email(deps.getEmail())
				.contact(deps.getContact())
				.address(deps.getAddress())
				.status(deps.getStatus()).build();
	}

	@Override
	public void delStaff(Integer id) {
		staffRepo.deleteById(id);
	}

	@Override
	public List<TblStaffsDto> getAllStaffs() {
		List<TblStaffs> staffs = staffRepo.findAll();
		
		List<TblStaffsDto> staffsDtoList = new ArrayList<>();
		
		for(TblStaffs s: staffs) {
			TblStaffsDto staffDto = TblStaffsDto.builder()
					.id(s.getId())
					.firstname(s.getFirstname())
					.lastname(s.getLastname())
					.username(s.getUsername())
					.email(s.getEmail())
					.contact(s.getContact())
					.address(s.getAddress())
					.status(s.getStatus()).build();
			
			staffsDtoList.add(staffDto);
		}
		return staffsDtoList;
	}

}
