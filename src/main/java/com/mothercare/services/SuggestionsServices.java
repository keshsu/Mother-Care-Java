package com.mothercare.services;

import java.util.List;

import com.mothercare.dto.TblSuggestionsDto;

public interface SuggestionsServices {

	public TblSuggestionsDto savesuggestion(TblSuggestionsDto suggestions);

	public List<TblSuggestionsDto> getAllsuggestions();

	public TblSuggestionsDto getSuggestionById(Integer id);

	void delSuggestion(Integer id);

	public TblSuggestionsDto updatesuggestion(TblSuggestionsDto suggestions);

}
