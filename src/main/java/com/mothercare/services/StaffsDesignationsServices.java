package com.mothercare.services;

import java.util.List;

import com.mothercare.dto.TblStaffsDesignationDto;

public interface StaffsDesignationsServices {

	public TblStaffsDesignationDto saveStaff(TblStaffsDesignationDto staffsdesgn);

	public TblStaffsDesignationDto getstaffById(Integer id);

	public void delStaffsDesignation(Integer id);

	public List<TblStaffsDesignationDto> getAllStaffsDesgts();

}
