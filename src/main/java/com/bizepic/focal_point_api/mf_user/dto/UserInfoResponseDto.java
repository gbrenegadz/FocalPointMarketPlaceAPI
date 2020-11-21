package com.bizepic.focal_point_api.mf_user.dto;

import com.bizepic.focal_point_api.common.entities.UserInfoEntity;
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
