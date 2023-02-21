package com.multiplex.dto;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDTO {
	private Integer id;
	@NotBlank
	private String name;
	@NotNull
	private String username;
	@Email
	private String emailId;
	@NotNull(message="Mobile Number Required")
	@Pattern(regexp="(^$|[0-9]{10})")
	private String mobileNumber;
	@Past
	private Date dateOfBirth;
	@NotNull
	private String password;
	private String roles;

}