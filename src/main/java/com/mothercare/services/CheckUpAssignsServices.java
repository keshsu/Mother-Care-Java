package com.mothercare.services;

import java.util.List;

import com.mothercare.dto.TblCheckupAssignsDto;

public interface CheckUpAssignsServices {
	
	public List<TblCheckupAssignsDto> getAllCheckupAssigns();
	
	public TblCheckupAssignsDto getCheckupAssignsById(Integer id);

	public void delCheckupAssigns(Integer id);

	public TblCheckupAssignsDto saveCheckupAssigns(TblCheckupAssignsDto checkupAssigns);
}
