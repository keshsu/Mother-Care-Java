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
public class TblPatientsStatusDto {
	private int id;
    private TblPatientsDto tblPatients;
    private String featured;
    private String status;
    
}
