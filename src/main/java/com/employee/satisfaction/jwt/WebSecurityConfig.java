package com.employee.satisfaction.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity //
@EnableGlobalMethodSecurity(prePostEnabled = true) //
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private UserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity.csrf().disable()
//				// dont authenticate this particular request
//				.authorizeRequests()
//				.antMatchers("/login", "/users/logout", "/authenticate", "/sigma", "/swagger-ui.html/**",
//						"/v2/api-docs/**", "/swagger-resources/**", "/webjars/springfox-swagger-ui/**")
//				.permitAll().
//				// all other requests need to be authenticated
//				anyRequest().authenticated().and().
//				// make sure we use stateless session; session won't be used to
//				// store user's state.
//				exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		
		
		
//		 http.cors().configurationSource(request-> {
//	            CorsConfiguration configuration = new CorsConfiguration();
//	            configuration.setAllowedOrigins(Arrays.asList("https://javadevjournal.com"));
//	            configuration.setAllowedMethods(Arrays.asList("GET","POST"));
//	            configuration.setAllowedHeaders(List.of("*"));
//	            return configuration;
//	        }).and()
		
		httpSecurity.cors().and().csrf().disable().
          authorizeRequests()
          .antMatchers("/login", "/users/logout", "/authenticate", "/sigma", "/swagger-ui.html/**",
					"/v2/api-docs/**", "/swagger-resources/**", "/webjars/springfox-swagger-ui/**").permitAll()
          .anyRequest().authenticated()
          .and()
          .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and()
          .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSecurity
          .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}



}
