/**
 * 
 */
package com.employee.satisfaction.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.ToString;

/**
 * @author kvenkateswara
 *
 */
@Entity
@Table(name = "roles")
@Data
@ToString
public class RolesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "rolename")
    private String rolename;
    
    @Column(name = "descrption")
    private String descrption;

	@Column(name = "createdby")
	private Integer createdBy;

	@Column(name = "createddate")
	@Temporal(TemporalType.DATE)
	private Date createdDate;

	@Column(name = "isactive")
	private Integer isactive;
}
