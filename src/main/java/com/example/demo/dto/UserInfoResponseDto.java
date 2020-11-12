package com.example.demo.dto;

import com.example.demo.entities.UserInfoEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Gilbert Renegado
 *
 */
public class UserInfoResponseDto {

	@JsonProperty("user")
	UserInfoEntity createdUser;

	public UserInfoResponseDto(UserInfoEntity createdUser) {
		this.createdUser = createdUser;
	}
}
