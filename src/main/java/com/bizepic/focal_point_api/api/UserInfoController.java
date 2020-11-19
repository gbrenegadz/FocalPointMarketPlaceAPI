package com.bizepic.focal_point_api.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bizepic.focal_point_api.common.entities.UserInfoEntity;
import com.bizepic.focal_point_api.common.exceptions.CustomResourceException;
import com.bizepic.focal_point_api.dto.StatusResponseDto;
import com.bizepic.focal_point_api.dto.UserInfoCreateRequestDto;
import com.bizepic.focal_point_api.dto.UserInfoResponseDto;
import com.bizepic.focal_point_api.dto.UserInfoUpdateRequestDto;
import com.bizepic.focal_point_api.services.UserInfoService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Gilbert Renegado
 *
 */
@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserInfoController {

	@Autowired
	UserInfoService service;
	
	@RequestMapping(method = RequestMethod.POST, 
			produces = "application/json")
	public ResponseEntity<UserInfoResponseDto> createUser(@Validated @RequestBody UserInfoCreateRequestDto request) {
		log.info("Create Users => Begin");
		UserInfoResponseDto response = service.createUser(request);
		log.info("Create Users => End");
		return new ResponseEntity<UserInfoResponseDto>(response, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, 
			produces = "application/json")
	public ResponseEntity<UserInfoResponseDto> updateUser(@Validated @RequestBody UserInfoUpdateRequestDto request) {
		log.info("Update Users => Begin");
		UserInfoResponseDto response = service.updateUser(request);
		log.info("Update Users => End");
		return new ResponseEntity<UserInfoResponseDto>(response, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/deactivate",
			method = RequestMethod.PUT, 
			produces = "application/json")
	public ResponseEntity<StatusResponseDto> deactivateUser(@Validated @RequestParam("userId") Long userId) throws CustomResourceException {
		log.info("Deactivate Users => Begin");
		StatusResponseDto response = service.deactivateUser(userId);
		log.info("Deactivate Users => End");
		return new ResponseEntity<StatusResponseDto>(response, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET,
			produces = "application/json")
	public ResponseEntity<Page<UserInfoEntity>> listUsers(@Validated @RequestParam(name = "pageNumber") int pageNumber) {
		log.info("List Users => Begin");
		Page<UserInfoEntity> response = service.listAllUsers(pageNumber);
		log.info("List Users => End");
		return new ResponseEntity<Page<UserInfoEntity>>(response, HttpStatus.OK);
	}
}
