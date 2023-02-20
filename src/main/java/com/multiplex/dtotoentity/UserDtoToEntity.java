package com.multiplex.dtotoentity;

import org.springframework.stereotype.Component;

import com.multiplex.dto.UsersDTO;
import com.multiplex.entity.User;

@Component
public class UserDtoToEntity {
   public User usersConvertUsersDtoEntity(UsersDTO usersDTO) {
	   User us =new User();
	   us.setId(usersDTO.getId());
	   us.setName(usersDTO.getName());
	   us.setDateOfBirth(usersDTO.getDateOfBirth());
	   us.setEmailId(usersDTO.getEmailId());
	   us.setMobileNumber(usersDTO.getMobileNumber());
	   us.setPassword(usersDTO.getPassword());
	   us.setUsername(usersDTO.getUsername());
	   us.setRoles(usersDTO.getRoles());
//	   us.setPassword(usersDTO.getcPassword());
	   return us;
   }
   public UsersDTO entityToDto(User users) {
	   UsersDTO usersDTO = new UsersDTO();
	   usersDTO.setId(users.getId());
	   usersDTO.setName(users.getName());
	   usersDTO.setUsername(users.getUsername());
	   usersDTO.setEmailId(users.getEmailId());
	   usersDTO.setMobileNumber(users.getMobileNumber());
	   usersDTO.setDateOfBirth(users.getDateOfBirth());
	   usersDTO.setPassword(users.getPassword());
	   usersDTO.setRoles(users.getRoles());
//	   usersDTO.setcPassward(users.getcPassward());
	   return usersDTO;
	   }
}
