package com.mothercare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mothercare.entities.TblSuggestions;

public interface SuggestionsRepository 
extends JpaRepository<TblSuggestions, Integer>{

}
