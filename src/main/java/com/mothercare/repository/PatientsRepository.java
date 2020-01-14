package com.mothercare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mothercare.entities.TblPatients;

public interface PatientsRepository extends JpaRepository<TblPatients, Integer>{

}
