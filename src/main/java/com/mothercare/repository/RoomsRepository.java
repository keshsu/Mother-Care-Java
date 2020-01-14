package com.mothercare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mothercare.entities.TblRooms;

public interface RoomsRepository extends JpaRepository<TblRooms, Integer>{

}
