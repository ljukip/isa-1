package com.isa59.isa.service;

import com.isa59.isa.dto.PatientDTO;
import com.isa59.isa.model.Authority;
import com.isa59.isa.model.User;
import com.isa59.isa.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private AuthorityService authService;
	
	@Autowired
	private EmailService emailService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}

	public User findByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}

	public User findById(Long id) throws AccessDeniedException {
		return userRepository.findById(id).orElseGet(null);
	}

	public List<User> findAll() throws AccessDeniedException {
		return userRepository.findAll();
	}

	public User save(PatientDTO userDTO) {
		List<User> users=userRepository.findAll();
		long id=0;
		for (int i=0; i<users.size(); i++) {
			id=users.get(i).getId()+1;
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++id register=" + id);
		User u = new User();
		u.setId(id);
		u.setUsername(userDTO.getUsername());
		u.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		u.setFirstName(userDTO.getFirstname());
		u.setLastName(userDTO.getLastname());
		u.setAddress(userDTO.getAddress());
		u.setCity(userDTO.getCity());
		u.setCountry(userDTO.getCountry());
		u.setPhone(userDTO.getPhone());
		u.setEnabled(false);
		u.setRole("PATIENT");

		List<Authority> auth = authService.findByName("ROLE_PATIENT");
		u.setAuthorities(auth);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++id =" + u.getId());
		u = this.userRepository.saveAndFlush(u);
		sendActivationEmail(u);
		return u;
	}

	private void sendActivationEmail(User newUser) {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setUsername(newUser.getUsername());
        patientDTO.setFirstname(newUser.getFirstName());

        // email sending
        try {
            System.out.println("Sending mail in process ..");
            emailService.sendActivationEmailAsync(patientDTO);
        }catch( Exception e ){
            System.out.println("Error during sending email: " + e.getMessage());
        }
	}

}
