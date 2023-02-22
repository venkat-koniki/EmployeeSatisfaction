/**
 * 
 */
package com.employee.satisfaction.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.satisfaction.entities.QuestionsAnsw;

/**
 * @author kvenkateswara
 *
 */
@Repository
public interface QuestAnswRepo  extends JpaRepository<QuestionsAnsw, Integer>{

}
