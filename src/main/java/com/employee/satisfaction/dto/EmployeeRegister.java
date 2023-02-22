/**
 * 
 */
package com.employee.satisfaction.dto;

import lombok.Data;

/**
 * @author kvenkateswara
 *
 */
@Data
public class EmployeeRegister {
 private String username;
 private String fname;
 private String lname;
 private String pasword;
 private String phonenumber;
 private String rolename;
 private Integer roleID;
 private String email;
 private Integer createdBy; 
 private String userID;
}
