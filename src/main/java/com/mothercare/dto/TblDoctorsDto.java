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
public class TblDoctorsDto{
	private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String contact;
    private String qualification;
    private String address;
    private String status;
    private Set<TblCheckupAssignsDto> tblCheckupAssigns;
    private TblSpecialityDto tblSpeciality;
    private Set<TblSuggestionsDto> tblSuggestions;
}
