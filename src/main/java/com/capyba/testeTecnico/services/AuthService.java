package com.capyba.testeTecnico.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.capyba.testeTecnico.repositories.UsuarioRepository;

@Service
public class AuthService implements UserDetailsService {
	
	

	    @Autowired
	    UsuarioRepository repository;
	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        return repository.findByEmail(username);
	    }
	

}
