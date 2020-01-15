package com.mothercare.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mothercare.dto.TblImagesDto;
import com.mothercare.services.ImageServices;

public class ImagesController {
	
	@Autowired
	ImageServices imgSer;

	
	@PostMapping("/save")
	public TblImagesDto saveImage(@RequestBody TblImagesDto Image) {
		return imgSer.saveimages(Image);
	}
	
	@PostMapping("/update")
	public TblImagesDto updateImage(@RequestBody TblImagesDto Image) {
		return imgSer.updateimages(Image);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<TblImagesDto> getImages(){
		return imgSer.getAllimages();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public TblImagesDto getImageById(@PathVariable Integer id){
		return imgSer.getimagesById(id);
	}
	
	@GetMapping("/delete/{id}")
	public void delImage(@PathVariable Integer id) {
		imgSer.delimages(id);
	}
}
