package com.example.demo.api;

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

import com.example.demo.dto.UserInfoCreateRequestDto;
import com.example.demo.dto.UserInfoCreateResponseDto;
import com.example.demo.entities.UserInfoEntity;
import com.example.demo.services.UserInfoService;

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
	public ResponseEntity<UserInfoCreateResponseDto> createUser(@Validated @RequestBody UserInfoCreateRequestDto request) {
		log.info("Create Users => Begin");
		UserInfoCreateResponseDto response = service.createUser(request);
		log.info("Create Users => End");
		return new ResponseEntity<UserInfoCreateResponseDto>(response, HttpStatus.OK);
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
