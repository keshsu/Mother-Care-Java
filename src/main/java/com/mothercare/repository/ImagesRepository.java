package com.mothercare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mothercare.entities.TblImages;

public interface ImagesRepository 
extends JpaRepository<TblImages, Integer>{

}
