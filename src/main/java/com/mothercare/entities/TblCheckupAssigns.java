// Generated with g9.

package com.mothercare.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="tbl_checkup_assigns")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TblCheckupAssigns implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Primary key. */
    protected static final String PK = "id";
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int id;
    @ManyToOne
    @JoinColumn(name="doctor_id")
    private TblDoctors tblDoctors;
    @ManyToOne
    @JoinColumn(name="patient_id")
    private TblPatients tblPatients;
    @ManyToOne
    @JoinColumn(name="treatment_id")
    private TblTreatmentCategory tblTreatmentCategory;
    @OneToMany(mappedBy="tblCheckupAssigns")
    private Set<TblSuggestions> tblSuggestions;
}
