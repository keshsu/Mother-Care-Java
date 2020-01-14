// Generated with g9.

package com.mothercare.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="tbl_suggestions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TblSuggestions implements Serializable {

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
    private String comment;
    @ManyToOne
    @JoinColumn(name="checkup_id")
    private TblCheckupAssigns tblCheckupAssigns;
    @ManyToOne
    @JoinColumn(name="prescription_id")
    private TblPrescription tblPrescription;
    @ManyToOne
    @JoinColumn(name="pharmacy_id")
    private TblPharmachies tblPharmachies;
}
