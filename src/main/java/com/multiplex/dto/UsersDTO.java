package com.multiplex.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDTO {
	private Integer id;
	private String name;
	private String username;
	private String emailId;
	private String mobileNumber;
	private Date dateOfBirth;
	private String password;
	private String roles;
}