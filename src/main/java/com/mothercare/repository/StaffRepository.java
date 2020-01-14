package com.mothercare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mothercare.entities.TblStaffs;

public interface StaffRepository extends JpaRepository<TblStaffs, Integer>{

}
