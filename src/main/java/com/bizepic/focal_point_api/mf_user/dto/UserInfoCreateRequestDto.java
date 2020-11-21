package com.bizepic.focal_point_api.mf_user.dto;

import java.time.LocalDateTime;

import com.bizepic.focal_point_api.common.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Gilbert Renegado
 *
 */
@Getter
@Setter
public class UserInfoCreateRequestDto {
	
	@NotNull
	@JsonProperty("fullName")
    private String fullName;
	
	@NotNull
	@JsonProperty("givenName")
    private String givenName;
	
	@NotNull
	@JsonProperty("familyName")
    private String familyName;
	
	@NotNull
	@JsonProperty("email")
    private String email;
	
	@NotNull
	@JsonProperty("imageUrl")
    private String imageUrl;
	
	@JsonIgnore
    private Integer isActive = Status.ACTIVE.getKey();
	
	@JsonIgnore
    private final LocalDateTime createdDatetime = LocalDateTime.now();

    @JsonIgnore
    private final LocalDateTime modifiedDatetime = LocalDateTime.now();
}
