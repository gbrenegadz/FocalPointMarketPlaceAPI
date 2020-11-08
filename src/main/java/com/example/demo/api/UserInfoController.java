package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.UserInfoEntity;
import com.example.demo.services.UserInfoService;
import com.example.dto.UserInfoCreateResponseDto;

@RestController
@RequestMapping(value = "/user")
public class UserInfoController {

	@Autowired
	UserInfoService service;

	@RequestMapping(value = "/",
			produces = "application/json",
			method = RequestMethod.POST)
	public ResponseEntity<Page<UserInfoEntity>> listUsers(@Validated @RequestParam(name = "pageNumber") int pageNumber) {
		Page<UserInfoEntity> response = service.listAllUsers(pageNumber);
		
		return new ResponseEntity<Page<UserInfoEntity>>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/create", produces = "application/json", method = RequestMethod.POST)
	public ResponseEntity<UserInfoCreateResponseDto> createUser(@Validated @RequestParam(name = "name") String name) {
		UserInfoEntity user = new UserInfoEntity();
		user.setGivenName("Gilbert");
		user.setFamilyName("Renegad");
		user.setFullName("Gilbert Renegado");
		user.setEmail("email@email.com");
		user.setImageUrl("imageUrl");

		UserInfoCreateResponseDto response = service.createUser(user);

		return new ResponseEntity<UserInfoCreateResponseDto>(response, HttpStatus.OK);
	}
}
