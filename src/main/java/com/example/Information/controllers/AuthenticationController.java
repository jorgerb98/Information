package com.example.Information.controllers;

import com.example.Information.constants.properties.JwtProperties;
import com.example.Information.models.AuthenticationRequest;
import com.example.Information.models.AuthenticationResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AuthenticationController {

	private final AuthenticationManager authenticationManager;
	private final JwtProperties jwtProperties;

	public AuthenticationController(AuthenticationManager authenticationManager, JwtProperties jwtProperties) {
		this.authenticationManager = authenticationManager;
		this.jwtProperties = jwtProperties;
	}

	@PostMapping("/auth/login")
	public AuthenticationResponse getToken(@Valid @RequestBody AuthenticationRequest authenticationRequest) {
		// Let spring check the credentials and get the authorities
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
														authenticationRequest.getPassword()));

		// Extract authorities from spring authentication
		List<String> authorityList = authentication.getAuthorities()
												   .stream()
												   .map(GrantedAuthority::getAuthority)
												   .collect(Collectors.toList());

		// Create JWS token
		String token = Jwts.builder()
						   .signWith(Keys.hmacShaKeyFor(jwtProperties.getSecret().getBytes()))
						   .setIssuer(jwtProperties.getIssuer())
						   .setSubject(authenticationRequest.getUsername())
						   .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExpirationInMillis()))
						   .claim(jwtProperties.getAuthoritiesClaim(), authorityList)
						   .compact();

		return new AuthenticationResponse(token);
	}

}
