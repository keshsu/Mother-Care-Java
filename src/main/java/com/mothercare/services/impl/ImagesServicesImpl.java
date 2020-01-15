package com.mothercare.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mothercare.dto.TblImagesDto;
import com.mothercare.entities.TblImages;
import com.mothercare.repository.ImagesRepository;
import com.mothercare.services.ImageServices;

@Service
public class ImagesServicesImpl implements ImageServices{
	
	ImagesRepository imageRep;

	@Override
	public TblImagesDto saveimages(TblImagesDto images) {
		TblImages depEntity = TblImages.builder()
				.id(images.getId())
				.name(images.getName())
				.build();
		
		depEntity= imageRep.save(depEntity);
		images.setId(depEntity.getId());
		
		return images;
	}

	@Override
	public List<TblImagesDto> getAllimages() {
		List<TblImages> tbat = imageRep.findAll();
		
		List<TblImagesDto> tblCatDtoList = new ArrayList<>();
		
		for(TblImages t: tbat) {
			
			TblImagesDto depDto = 	TblImagesDto.builder()
				.id(t.getId())
				.name(t.getName()).build();
			
			tblCatDtoList.add(depDto);
		}
		return tblCatDtoList;
	}

	@Override
	public TblImagesDto getimagesById(Integer id) {
		TblImages deps = imageRep.findById(id).get();
		return TblImagesDto.builder()
				.id(deps.getId())
				.name(deps.getName()).build();
	}

	@Override
	public void delimages(Integer id) {
		imageRep.deleteById(id);
	}

	@Override
	public TblImagesDto updateimages(TblImagesDto image) {

		Optional<TblImages> img = imageRep.findById(image.getId());
		if(img.isPresent()) {
			TblImages depEntity = TblImages.builder()
					.id(image.getId())
					.name(image.getName())
					.build();
			
			depEntity= imageRep.save(depEntity);
		}
		return image;
	}

}
