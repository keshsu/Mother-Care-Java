package com.mothercare.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mothercare.dto.TblTreatmentCategoryDto;
import com.mothercare.services.TreatmentCategoryServices;

@RestController
@RequestMapping("/treatmentCategory")
public class TreatmentCategoryController {
	
	@Autowired
	TreatmentCategoryServices treatmentCatSer;
	
	@PostMapping("/save")
	public TblTreatmentCategoryDto savetreatmentCats(@RequestBody TblTreatmentCategoryDto treatmentCats) {
		return treatmentCatSer.savetreatmentCat(treatmentCats);
	}

	@PostMapping("/update")
	public TblTreatmentCategoryDto updatetreatmentCats(@RequestBody TblTreatmentCategoryDto treatmentCats) {
		return treatmentCatSer.updatetreatmentCat(treatmentCats);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<TblTreatmentCategoryDto> getPatients(){
		return treatmentCatSer.getAlltreatmentCats();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public TblTreatmentCategoryDto gettreatmentCatsById(@PathVariable Integer id){
		return treatmentCatSer.gettreatmentCatById(id);
	}
	
	@GetMapping("/delete/{id}")
	public void deltreatmentCat(@PathVariable Integer id) {
		treatmentCatSer.deltreatmentCat(id);
	}

}
