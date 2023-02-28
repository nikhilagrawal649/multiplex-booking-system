package com.multiplex.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.multiplex.config.JwtUtils;
import com.multiplex.dto.UsersDTO;
import com.multiplex.dtotoentity.UserDtoToEntity;
import com.multiplex.entity.LoginRequest;
import com.multiplex.entity.LoginResponse;
import com.multiplex.entity.User;
import com.multiplex.entity.UserLogin;
import com.multiplex.exception.EmailAlreadyExistException;
import com.multiplex.exception.EmailIdFormatException;
import com.multiplex.exception.PasswordNotMatchException;
import com.multiplex.exception.ShowException;
import com.multiplex.exception.WrongCredentialsException;
import com.multiplex.service.UserService;
import com.multiplex.serviceimpl.JpaUserDetailsService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	@Autowired
	UserDtoToEntity userDtoToEntity;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
    private JpaUserDetailsService userDetailsService;


	@Autowired
    private JwtUtils jwtUtils;
	
	@GetMapping("/home")
	public String home() {
		return "I am inside home.";
	}

	@CrossOrigin
	@PostMapping("/usersregistration")
	public User registerUser(@RequestBody @Valid UsersDTO userDto)
			throws EmailAlreadyExistException, PasswordNotMatchException, EmailIdFormatException {
		String tempEmailId = userDto.getEmailId();
		if (tempEmailId != null && !"".equals(tempEmailId)) {
			User userObj = service.fetchUserByEmailId(tempEmailId);
			if (userObj != null) {
				throw new EmailAlreadyExistException("User with " + tempEmailId + " is already Exist");
			}
		}
		String tempPassword = new BCryptPasswordEncoder().encode(userDto.getPassword());
		userDto.setPassword(tempPassword);
//		String tempCPassward = userDto.getcPassward();
//		if(tempCPassward != null && !tempCPassward.equals(tempPassward)) {
//		throw new PasswordNotMatchException();
//		}
		if (userDto.getEmailId().isEmpty() || userDto.getEmailId().isEmpty()
				|| !userDto.getEmailId().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
			throw new EmailIdFormatException("Email Id is Wrong format");
		}

		User userObj = userDtoToEntity.usersConvertUsersDtoEntity(userDto);

		return service.saveUser(userObj);

	}

//	@CrossOrigin
//	@SecurityRequirement(name = "Bearer Authentication")
//    @PreAuthorize(value="hasRole('ROLE_ADMIN') || hasRole('ROLE_USER')")
//	@PostMapping("/userlogin")
//	public String loginUser(@RequestBody UserLogin user) throws WrongCredentialsException {
//		String tempEmailId = user.username;
//		String tempPass = user.password;
//
//		User userObj = null;
//		if (tempEmailId != null && tempPass != null) {
//			userObj = service.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
//		}
//
//		if (userObj == null) {
//			throw new WrongCredentialsException("WrongCredentials");
//		}
//		return "Login Successfull";
//	}

	@PostMapping("/userlogin")
	public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest request, HttpServletResponse response) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),
					request.getPassword(), new ArrayList<>()));
			final UserDetails user = userDetailsService.loadUserByUsername(request.getUsername());
			if (user != null) {
				String jwt = jwtUtils.generateToken(user);
				Cookie cookie = new Cookie("jwt", jwt);
				cookie.setMaxAge(7 * 24 * 60 * 60); // expires in 7 days
//                cookie.setSecure(true);
				cookie.setHttpOnly(true);
				cookie.setPath("/"); // Global
				response.addCookie(cookie);
				return ResponseEntity.ok(new LoginResponse(request.getUsername(), jwt,"Login Successful."));
			}
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		}
	}

	@CrossOrigin
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN') || hasRole('ROLE_USER')")
	@GetMapping("/getByEmail/{email}")
	public User getshowById(@PathVariable String email) {
		User user = service.getUserByEmail(email);
		if (user != null) {
			return user;
		} else {
			throw new ShowException();
		}
	}

}
