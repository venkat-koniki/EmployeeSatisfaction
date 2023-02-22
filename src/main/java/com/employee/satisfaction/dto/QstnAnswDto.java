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
public class QstnAnswDto {
  private Integer qId;
  private Integer createdBy;
  private Integer rating;
  private String comments;
  private Integer qanswId;
  private Integer empId;
  
}
