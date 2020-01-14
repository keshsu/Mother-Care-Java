package com.mothercare.services;

import java.util.List;

import com.mothercare.dto.TblImagesDto;

public interface ImageServices {

	public TblImagesDto saveimages(TblImagesDto images);

	public List<TblImagesDto> getAllimages();

	public TblImagesDto getimagesById(Integer id);

	void delimages(Integer id);

}
