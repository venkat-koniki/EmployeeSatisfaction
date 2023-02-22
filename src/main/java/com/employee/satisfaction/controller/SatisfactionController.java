/**
 * 
 */
package com.employee.satisfaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.satisfaction.dto.EmployeeRegister;
import com.employee.satisfaction.dto.LoginInput;
import com.employee.satisfaction.dto.QstnAnswDto;
import com.employee.satisfaction.dto.QstnInput;
import com.employee.satisfaction.dto.UserOutputDTO;
import com.employee.satisfaction.jwt.JwtTokenUtil;
import com.employee.satisfaction.service.SatisfactionService;

/**
 * @author kvenkateswara
 *
 */
@RestController
public class SatisfactionController {
	@Autowired
	SatisfactionService objSatisfactionService;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginInput login) throws Exception {
		if (StringUtils.hasText(login.getUsername()) && StringUtils.hasText(login.getPassword())) {
			UserOutputDTO user = objSatisfactionService.getUser(login.getUsername(),login.getPassword());
			final UserDetails userDetails = jwtInMemoryUserDetailsService
					.loadUserByUsername(login.getUsername());

			final String token = jwtTokenUtil.generateToken(userDetails);
			
			if (user != null) {
				user.setToken(token);
				return new ResponseEntity<>(user, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody EmployeeRegister login) throws Exception {		
		
		return new ResponseEntity<>(objSatisfactionService.register(login), HttpStatus.OK);

	}
	
	@GetMapping("/getEmployees")
	public ResponseEntity<?> getEmployees() throws Exception {
		
		return new ResponseEntity<>(objSatisfactionService.getEmployees(), HttpStatus.OK);

	}
	
	@GetMapping("/getQstn")
	public ResponseEntity<?> getQstn() throws Exception {
		
		return new ResponseEntity<>(objSatisfactionService.getQstn(), HttpStatus.OK);

	}
	
	@GetMapping("/getSatisfactoryReport")
	public ResponseEntity<?> getSatisfactoryReport() throws Exception {
		
		return new ResponseEntity<>(objSatisfactionService.getSatisfactoryReport(), HttpStatus.OK);

	}
	
	@PostMapping("/addQuestion")
	public ResponseEntity<?> addQuestion(@RequestBody QstnInput login) throws Exception {
		
		return new ResponseEntity<>(objSatisfactionService.addQuestion(login), HttpStatus.OK);

	}
	
	@PostMapping("/insertRating")
	public ResponseEntity<?> insertRating(@RequestBody QstnAnswDto login) throws Exception {
		
		return new ResponseEntity<>(objSatisfactionService.insertRating(login), HttpStatus.OK);

	}
	
}
