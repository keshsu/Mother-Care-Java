package com.mothercare.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mothercare.dto.TblRoomsDto;
import com.mothercare.services.RoomsServices;

@RestController
@RequestMapping("/rooms")
public class RoomsController{

	@Autowired
	RoomsServices roomServices;
	
	@PostMapping("/save")
	public TblRoomsDto saveRooms(@RequestBody TblRoomsDto rooms) {
		return roomServices.saveRoom(rooms);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<TblRoomsDto> getRooms(){
		return roomServices.getAllRooms();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public TblRoomsDto getRoomById(@PathVariable Integer id){
		return roomServices.getRoomById(id);
	}
	
	@GetMapping("/delete/{id}")
	public void delRoom(@PathVariable Integer id) {
		roomServices.delRoom(id);
	}
}
