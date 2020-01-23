package com.mothercare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mothercare.entities.TblAdmins;

public interface AdminRepository extends JpaRepository<TblAdmins, Integer>{
	public TblAdmins findByUsername(String username);
}
