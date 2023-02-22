/**
 * 
 */
package com.employee.satisfaction.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.satisfaction.entities.UsersEntity;

/**
 * @author kvenkateswara
 *
 */
@Repository
public interface UserRepo extends JpaRepository<UsersEntity, Integer>{

	@Query(value="select t from UsersEntity t where t.uname=:username")
	List<UsersEntity> findByUsername(String username);

	@Query(value="select t from UsersEntity t where t.uname=:username and t.password=:password")
	Optional<UsersEntity> findByUsername(String username, String password);

}
