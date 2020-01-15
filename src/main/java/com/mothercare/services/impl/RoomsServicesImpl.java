package com.mothercare.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mothercare.dto.TblDepartmentsDto;
import com.mothercare.dto.TblRoomsDto;
import com.mothercare.entities.TblDepartments;
import com.mothercare.entities.TblRooms;
import com.mothercare.repository.RoomsRepository;
import com.mothercare.services.RoomsServices;

@Service
public class RoomsServicesImpl implements RoomsServices{

	@Autowired
	RoomsRepository roomRepo;
	
	@Override
	public TblRoomsDto saveRoom(TblRoomsDto rooms) {
		TblDepartments dep = TblDepartments.builder()
				.id(rooms.getTblDepartments().getId()).build();
		
		TblRooms roomEntity = TblRooms.builder()
				.id(rooms.getId())
				.name(rooms.getName())
				.tblDepartments(dep)
				.status(rooms.getStatus()).build();
		
		roomEntity= roomRepo.save(roomEntity);
		rooms.setId(roomEntity.getId());
		
		return rooms;
	}

	@Override
	public List<TblRoomsDto> getAllRooms() {
		List<TblRooms> room = roomRepo.findAll();
		
		List<TblRoomsDto> roomsDto = new ArrayList<>();		
		for(TblRooms u: room) {
			TblDepartmentsDto dep = TblDepartmentsDto.builder()
					.id(u.getTblDepartments().getId())
					.name(u.getTblDepartments().getName()).build();
			
			TblRoomsDto rmDto = TblRoomsDto.builder()
					.id(u.getId())
					.name(u.getName())
					.tblDepartments(dep)
					.status(u.getStatus()).build();
			
			roomsDto.add(rmDto);
		}
		return roomsDto;
	}

	@Override
	public TblRoomsDto getRoomById(Integer id) {
		TblRooms room = roomRepo.findById(id).get();
		
		TblDepartmentsDto dep = TblDepartmentsDto.builder()
				.id(room.getTblDepartments().getId())
				.name(room.getTblDepartments().getName()).build();
		
		return TblRoomsDto.builder()
				.id(room.getId())
				.name(room.getName())
				.tblDepartments(dep)
				.status(room.getStatus()).build();
	}

	@Override
	public void delRoom(Integer id) {
		roomRepo.deleteById(id);
	}

	@Override
	public TblRoomsDto UpdateRoom(TblRoomsDto rooms) {	
		Optional<TblRooms> room = roomRepo.findById(rooms.getId());
		
		if(room.isPresent()) {			
			TblDepartments dep = TblDepartments.builder()
					.id(rooms.getTblDepartments().getId()).build();
			
			TblRooms roomEntity = TblRooms.builder()
					.id(rooms.getId())
					.name(rooms.getName())
					.tblDepartments(dep)
					.status(rooms.getStatus()).build();
			
			roomEntity= roomRepo.save(roomEntity);
		}
		return rooms;
	}

}
