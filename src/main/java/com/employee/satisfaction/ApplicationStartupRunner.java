/**
 * 
 */
package com.employee.satisfaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.employee.satisfaction.service.SatisfactionService;

/**
 * @author kvenkateswara
 *
 */
@Component
public class ApplicationStartupRunner implements CommandLineRunner {
	@Autowired
	SatisfactionService satisfactionService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("1");
		satisfactionService.intializeDefaultValues();
	}
}
