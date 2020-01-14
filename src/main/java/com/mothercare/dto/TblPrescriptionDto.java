package com.mothercare.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TblPrescriptionDto {
    private int id;
    private String name;
    private String description;
    private String comments;
    private Set<TblSuggestionsDto> tblSuggestions;
}