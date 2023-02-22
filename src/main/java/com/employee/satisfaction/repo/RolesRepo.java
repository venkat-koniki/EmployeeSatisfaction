/**
 * 
 */
package com.employee.satisfaction.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.satisfaction.entities.RolesEntity;

/**
 * @author kvenkateswara
 *
 */
@Repository
public interface RolesRepo  extends JpaRepository<RolesEntity, Integer>{

}
