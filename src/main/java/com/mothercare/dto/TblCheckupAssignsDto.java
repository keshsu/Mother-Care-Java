// Generated with g9.

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
public class TblCheckupAssignsDto {

    private int id;
    private TblDoctorsDto tblDoctors;
    private TblPatientsDto tblPatients;
    private TblTreatmentCategoryDto tblTreatmentCategory;
    private Set<TblSuggestionsDto> tblSuggestions;
}
