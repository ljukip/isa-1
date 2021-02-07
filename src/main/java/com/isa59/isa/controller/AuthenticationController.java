package com.isa59.isa.controller;

import com.isa59.isa.dto.PatientDTO;
import com.isa59.isa.model.User;
import com.isa59.isa.model.UserTokenState;
import com.isa59.isa.repository.UserRepository;
import com.isa59.isa.security.TokenUtils;
import com.isa59.isa.security.auth.JwtAuthenticationRequest;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {

	private Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/login")
	public ResponseEntity<User> createAuthenticationToken(
			@RequestBody JwtAuthenticationRequest authenticationRequest, HttpServletResponse response) {
		System.out.println("inLogin" + authenticationRequest.getUsername() + authenticationRequest.getPassword());
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				authenticationRequest.getUsername(),
				authenticationRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		//User user = (User) authentication.getPrincipal();
		
		User user=userService.findByUsername(authenticationRequest.getUsername());
		System.out.println("user++++++++++++++++++" + user);
		String jwt = tokenUtils.generateToken(user.getUsername(), user.getRole());
		int expiresIn = tokenUtils.getExpiredIn();
		//String jwtSession = createJwtSession(user.getUsername());
		user.setJwt(jwt); //set token to the object in request
		
		System.out.println("loggingIn" + user);
		return ResponseEntity.ok(user);
	}

	@PostMapping("/signup")
	public ResponseEntity<User> addUser(@RequestBody PatientDTO userDTO) {

		User existUser = userService.findByUsername(userDTO.getUsername());
		if (existUser != null)
			return new ResponseEntity<>(existUser, HttpStatus.CONFLICT);

		User createdUser = userService.save(userDTO);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

	@GetMapping("activate/{username}")
    public void activateAccount(@PathVariable String username, HttpServletResponse httpServletResponse) {
		User user = userRepository.findByUsername(username);
		user.setEnabled(true);
		userRepository.saveAndFlush(user);
		String projectUrl = "http://localhost:8081/#/login";
        httpServletResponse.setHeader("Location", projectUrl);
        httpServletResponse.setStatus(302);
    }
}
