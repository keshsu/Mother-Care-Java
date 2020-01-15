package com.mothercare.services;

import java.util.List;

import com.mothercare.dto.TblRoomsDto;

public interface RoomsServices {

	public TblRoomsDto saveRoom(TblRoomsDto rooms);

	public List<TblRoomsDto> getAllRooms();

	public TblRoomsDto getRoomById(Integer id);

	public void delRoom(Integer id);

	public TblRoomsDto UpdateRoom(TblRoomsDto rooms);
}
