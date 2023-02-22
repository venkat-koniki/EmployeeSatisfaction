package com.employee.satisfaction.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.employee.satisfaction.entities.UsersEntity;
import com.employee.satisfaction.repo.UserRepo;



@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		List<UsersEntity> user=userRepo.findByUsername(username);
		
		if (!user.isEmpty()) {
			return new User(username, user.get(0).getPassword(),
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}