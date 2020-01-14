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

@Entity(name="tbl_patients")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TblPatients implements Serializable {

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
    @Column(length=50)
    private String firstname;
    @Column(length=50)
    private String lastname;
    @Column(length=50)
    private String pfirstname;
    @Column(length=50)
    private String plastname;
    @Column(length=50)
    private String email;
    @Column(length=10)
    private String password;
    @Column(length=15)
    private String contact;
    @Column(length=15)
    private String pcontact;
    @Column(length=100)
    private String address;
    @OneToMany(mappedBy="tblPatients")
    private Set<TblCheckupAssigns> tblCheckupAssigns;
}
