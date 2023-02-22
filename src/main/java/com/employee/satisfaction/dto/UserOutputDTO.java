/**
 * 
 */
package com.employee.satisfaction.dto;

import java.util.Date;

import lombok.Data;

/**
 * @author kvenkateswara
 *
 */
@Data
public class UserOutputDTO {
	private Integer id;
	private String fname;
	private String lname;
	private String uname;
	private String password;
	private String phonenumber;
	private String email;
	private Integer roleid;
	private Integer createdBy;
	private Date createdDate;
	private Integer isactive;
	private String token;
}
