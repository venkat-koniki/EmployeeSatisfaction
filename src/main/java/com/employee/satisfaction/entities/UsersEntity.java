/**
 * 
 */
package com.employee.satisfaction.entities;

import java.math.BigDecimal;
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
 * @author konik
 *
 */
@Entity
@Table(name = "users")
@Data
@ToString
public class UsersEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fname")
    private String fname;
    
    @Column(name = "lname")
    private String lname;
    
    @Column(name = "uname")
    private String uname;
    
    @Column(name = "password")
    private String password;
   
    @Column(name = "phonenumber")
    private String phonenumber;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "roleid")
    private Integer roleid;
    
    @Column(name = "createdby")
    private Integer createdBy;        
    
    @Column(name = "createddate")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    
    @Column(name = "isactive")
    private Integer isactive;
}
