package com.capyba.testeTecnico.cofigurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
	        return  httpSecurity
	                .csrf(csrf -> csrf.disable())
	                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	                .authorizeHttpRequests(authorize -> authorize
	                		 .requestMatchers("/swagger-ui/**", "/swagger-ui.html", "/v3/api-docs/**").permitAll()
	                		.requestMatchers(HttpMethod.POST,"/auth/login").permitAll()
	                		.requestMatchers(HttpMethod.POST,"/auth/registrar").permitAll()
	                		.anyRequest().authenticated()
	                )
	                
	                .build();
	    }
	 
	 
	 @Bean
	 public AuthenticationManager autheticaAuthenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		 return authenticationConfiguration.getAuthenticationManager();
		 
	 }
	 
	 @Bean
	 public PasswordEncoder passWordEncoder() {
		 return new BCryptPasswordEncoder();
	 }
	
	
}