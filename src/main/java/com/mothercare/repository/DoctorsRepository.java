package com.mothercare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mothercare.entities.TblDoctors;

public interface DoctorsRepository extends JpaRepository<TblDoctors, Integer>{

}
