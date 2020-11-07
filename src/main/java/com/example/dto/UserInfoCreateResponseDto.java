package com.example.dto;

import com.example.demo.entities.UserInfoEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInfoCreateResponseDto {

	@JsonProperty("createdUser")
	UserInfoEntity createdUser;

	public UserInfoCreateResponseDto(UserInfoEntity createdUser) {
		this.createdUser = createdUser;
	}
}
