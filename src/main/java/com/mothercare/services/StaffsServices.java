package com.mothercare.services;

import java.util.List;

import com.mothercare.dto.TblStaffsDto;

public interface StaffsServices {
	public TblStaffsDto saveStaff(TblStaffsDto staffs);

	public List<TblStaffsDto> getAllStaffs();

	public TblStaffsDto getstaffById(Integer id);

	public void delStaff(Integer id);

	public TblStaffsDto updateStaff(TblStaffsDto staffs);
}
