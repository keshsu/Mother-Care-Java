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
public class TblPatientsDto{
    private int id;
    private String firstname;
    private String lastname;
    private String pfirstname;
    private String plastname;
    private String email;
    private String password;
    private String contact;
    private String pcontact;
    private String address;
    private Set<TblCheckupAssignsDto> tblCheckupAssigns;
}
