package com.mothercare.dto;

import java.util.Set;

import com.mothercare.entities.TblCheckupAssigns;

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
public class TblTreatmentCategoryDto {
	private int id;
    private String name;
    private String status;
    private Set<TblCheckupAssigns> tblCheckupAssigns;
}
