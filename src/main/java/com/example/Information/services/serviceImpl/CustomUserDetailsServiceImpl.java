package com.example.Information.services.serviceImpl;

import com.example.Information.entities.Person;
import com.example.Information.repositories.PersonRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

	private final PersonRepository personRepository;

	public CustomUserDetailsServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return personRepository.findByNameIgnoreCase(username).orElseThrow(() -> new UsernameNotFoundException(String.format("No user found with username '%s'.", username)));
	}

}
