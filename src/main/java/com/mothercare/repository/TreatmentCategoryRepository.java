package com.mothercare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mothercare.entities.TblTreatmentCategory;

public interface TreatmentCategoryRepository extends JpaRepository<TblTreatmentCategory, Integer>{

}
