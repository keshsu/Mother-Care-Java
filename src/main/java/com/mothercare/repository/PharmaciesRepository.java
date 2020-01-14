package com.mothercare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mothercare.entities.TblPharmachies;

public interface PharmaciesRepository extends JpaRepository<TblPharmachies, Integer>{

}
