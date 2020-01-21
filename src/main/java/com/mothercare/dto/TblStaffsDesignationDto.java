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
public class TblStaffsDesignationDto {
	private int id;
    private int tblStaffs;
    private int tblDesignations;
}

