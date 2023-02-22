package com.employee.satisfaction.service;

import com.employee.satisfaction.dto.EmployeeRegister;
import com.employee.satisfaction.dto.QstnAnswDto;
import com.employee.satisfaction.dto.QstnInput;
import com.employee.satisfaction.dto.UserOutputDTO;
import com.employee.satisfaction.entities.QuestinsEntity;
import com.employee.satisfaction.entities.QuestionsAnsw;
import com.employee.satisfaction.entities.UsersEntity;

public interface SatisfactionService {
  void intializeDefaultValues();

UserOutputDTO getUser(String username, String password);

UsersEntity register(EmployeeRegister login);

QuestinsEntity addQuestion(QstnInput login);

QuestionsAnsw insertRating(QstnAnswDto login);

Object getEmployees();

Object getSatisfactoryReport();

Object getQstn();
}
