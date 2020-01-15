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

import com.mothercare.dto.TblSuggestionsDto;
import com.mothercare.services.SuggestionsServices;

@RestController
@RequestMapping("/suggestions")
public class SuggestionsController {
	@Autowired
	SuggestionsServices suggestionSer;
	
	@PostMapping("/save")
	public TblSuggestionsDto saveSuggestions(@RequestBody TblSuggestionsDto suggestions) {
		return suggestionSer.savesuggestion(suggestions);
	}

	@PostMapping("/update")
	public TblSuggestionsDto updateSuggestions(@RequestBody TblSuggestionsDto suggestions) {
		return suggestionSer.updatesuggestion(suggestions);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<TblSuggestionsDto> getsuggestions(){
		return suggestionSer.getAllsuggestions();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public TblSuggestionsDto getsuggestionsById(@PathVariable Integer id){
		return suggestionSer.getSuggestionById(id);
	}
	
	@GetMapping("/delete/{id}")
	public void delSuggestion(@PathVariable Integer id) {
		suggestionSer.delSuggestion(id);
	}

}
