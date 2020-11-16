package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * 
 * @author Gilbert Renegado
 *
 */
@Data
public class StatusResponseDto {

	@JsonProperty("status")
	String status;
	
	@JsonProperty("message")
	String message;
}
