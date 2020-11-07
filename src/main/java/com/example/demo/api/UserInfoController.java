package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.UserInfoEntity;
import com.example.demo.services.UserInfoService;
import com.example.dto.UserInfoCreateResponseDto;

@RestController
public class UserInfoController {

	@Autowired
	UserInfoService service;

	@PostMapping("user/create")
	public UserInfoCreateResponseDto createUser() {
		UserInfoEntity user = new UserInfoEntity();
		user.setGivenName("Gilbert");
		user.setFamilyName("Renegad");
		user.setFullName("Gilbert Renegado");
		user.setEmail("email@email.com");
		user.setImageUrl("imageUrl");
		return service.createUser(user);
	}
}
