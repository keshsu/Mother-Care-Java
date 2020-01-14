package com.mothercare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mothercare.entities.TblPrescription;

public interface PrescriptionRepository 
extends JpaRepository<TblPrescription, Integer>{

}
