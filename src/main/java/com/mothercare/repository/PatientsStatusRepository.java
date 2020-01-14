package com.mothercare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mothercare.entities.TblPatientStatus;

public interface PatientsStatusRepository 
extends JpaRepository<TblPatientStatus, Integer>{

}
