// Generated with g9.

package com.mothercare.dto;

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
public class TblSuggestionsDto {
	private int id;
    private String comment;
    private TblCheckupAssignsDto tblCheckupAssigns;
    private TblPrescriptionDto tblPrescription;
    private TblPharmachiesDto tblPharmachies;
}
