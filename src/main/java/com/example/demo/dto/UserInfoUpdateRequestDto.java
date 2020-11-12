package com.example.demo.dto;

import java.time.LocalDateTime;

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
public class UserInfoUpdateRequestDto {

	@NotNull
	@JsonProperty("id")
    private Long id;
	
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
    private final LocalDateTime modifiedDatetime = LocalDateTime.now();
}
