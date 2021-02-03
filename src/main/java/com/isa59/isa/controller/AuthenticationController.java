package com.isa59.isa.controller;

import com.isa59.isa.dto.PatientDTO;
import com.isa59.isa.model.User;
import com.isa59.isa.model.UserTokenState;
import com.isa59.isa.security.TokenUtils;
import com.isa59.isa.security.auth.JwtAuthenticationRequest;
import com.isa59.isa.service.EmailService;
import com.isa59.isa.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

	private Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;

	@PostMapping("/login")
	public ResponseEntity<UserTokenState> createAuthenticationToken(
			@RequestBody JwtAuthenticationRequest authenticationRequest, HttpServletResponse response) {

		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				authenticationRequest.getUsername(),
				authenticationRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		User user = (User) authentication.getPrincipal();
		String jwt = tokenUtils.generateToken(user.getUsername());
		int expiresIn = tokenUtils.getExpiredIn();

		return ResponseEntity.ok(new UserTokenState(jwt, expiresIn, user.getRole()));
	}

	@PostMapping("/signup")
	public ResponseEntity<User> addUser(@RequestBody PatientDTO userDTO) {

		User existUser = userService.findByUsername(userDTO.getUsername());
		if (existUser != null)
			return new ResponseEntity<>(existUser, HttpStatus.CONFLICT);

		User createdUser = userService.save(userDTO);
//		try {
//			emailService.sendMail(createdUser);
//		} catch (Exception e) {
//			logger.info("Error sending mail: " + e.getMessage());
//		}

		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

}
