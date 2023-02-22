/**
 * 
 */
package com.employee.satisfaction.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.satisfaction.entities.QuestinsEntity;
import com.employee.satisfaction.entities.UsersEntity;

/**
 * @author kvenkateswara
 *
 */
@Repository
public interface QuestionRepo  extends JpaRepository<QuestinsEntity, Integer>{

}
