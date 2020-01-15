package com.mothercare.services;

import java.util.List;

import com.mothercare.dto.TblDesignationsDto;

public interface DesignationsServices {
	public List<TblDesignationsDto> getAllDesignationsDetails();
	
	public TblDesignationsDto getDesignationsById(Integer id);
	
	public TblDesignationsDto saveDesignation(TblDesignationsDto designation);
	
	public void delDesignation(Integer id);

	public TblDesignationsDto updateDesignation(TblDesignationsDto designation);
}
