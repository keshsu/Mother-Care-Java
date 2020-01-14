package com.mothercare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mothercare.entities.TblDepartments;

public interface DepartmentsRepository extends JpaRepository<TblDepartments, Integer>{

}
