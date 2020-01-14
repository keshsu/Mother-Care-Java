// Generated with g9.

package com.mothercare.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="tbl_speciality")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TblSpeciality implements Serializable {

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
    @Column(length=255)
    private String name;
    @Column(length=10)
    private String status;
    @OneToMany(mappedBy="tblSpeciality")
    private Set<TblDoctors> tblDoctors;
}
