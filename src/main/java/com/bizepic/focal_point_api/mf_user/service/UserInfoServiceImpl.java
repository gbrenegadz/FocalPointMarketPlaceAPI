package com.bizepic.focal_point_api.mf_user.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.bizepic.focal_point_api.common.dto.StatusResponseDto;
import com.bizepic.focal_point_api.common.entities.UserInfoEntity;
import com.bizepic.focal_point_api.common.enums.Status;
import com.bizepic.focal_point_api.common.exceptions.CustomResourceException;
import com.bizepic.focal_point_api.common.utils.LocalDateTimeAttributeConverterUtil;
import com.bizepic.focal_point_api.mf_user.dto.UserInfoCreateRequestDto;
import com.bizepic.focal_point_api.mf_user.dto.UserInfoResponseDto;
import com.bizepic.focal_point_api.mf_user.dto.UserInfoUpdateRequestDto;
import com.bizepic.focal_point_api.mf_user.repositories.UserInfoRepository;

/**
 * 
 * @author Gilbert Renegado
 *
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
	private final LocalDateTimeAttributeConverterUtil localDateTimeConverter = new LocalDateTimeAttributeConverterUtil();

	@Autowired
	UserInfoRepository repository;

	@Autowired
	private Environment env;

	@Override
	public UserInfoResponseDto createUser(UserInfoCreateRequestDto request) {

		// Create user entity for create
		UserInfoEntity user = new UserInfoEntity();
		user.setGivenName(request.getGivenName());
		user.setFamilyName(request.getFamilyName());
		user.setFullName(request.getFullName());
		user.setEmail(request.getEmail());
		user.setImageUrl(request.getImageUrl());
		user.setIsActive(request.getIsActive());
		user.setCreatedDatetime(localDateTimeConverter.convertToDatabaseColumn(request.getCreatedDatetime()));
		user.setModifiedDatetime(localDateTimeConverter.convertToDatabaseColumn(request.getModifiedDatetime()));

		// Insert data and create instance for the response
		UserInfoResponseDto createdUser = new UserInfoResponseDto(repository.save(user));

		return createdUser;
	}

	@Override
	public UserInfoResponseDto updateUser(UserInfoUpdateRequestDto request) {

		// Query user
		UserInfoEntity user = repository.findByUserId(request.getId());
		if (user != null) {
			user.setGivenName(request.getGivenName());
			user.setFamilyName(request.getFamilyName());
			user.setFullName(request.getFullName());
			user.setEmail(request.getEmail());
			user.setImageUrl(request.getImageUrl());
			user.setModifiedDatetime(localDateTimeConverter.convertToDatabaseColumn(request.getModifiedDatetime()));
		} else {
			String error = env.getProperty("error.resource.not_found.user");
			throw new ResourceNotFoundException(error);
		}

		// Create response
		UserInfoResponseDto updatedUser = new UserInfoResponseDto(repository.save(user));
		return updatedUser;
	}

	@Override
	public StatusResponseDto deactivateUser(Long id) throws CustomResourceException {

		// Query user and set user status to Status.INACTIVE
		UserInfoEntity user = repository.findByUserId(id);
		if (user != null) {
			user.setIsActive(Status.INACTIVE.getKey());
			user.setModifiedDatetime(localDateTimeConverter.convertToDatabaseColumn(LocalDateTime.now()));
		} else {
			String error = env.getProperty("error.resource.not_found.user");
			throw new CustomResourceException(error);
		}

		// Save new status
		UserInfoEntity updatedUser = repository.save(user);
		if (updatedUser.getIsActive() == Status.ACTIVE.getKey()) {
			String error = env.getProperty("error.resource.deactivate.user_failed");
			Throwable cause = new Throwable(env.getProperty("error.resource.deactivate.user_cause"));
			throw new CustomResourceException(error, cause);
		}
		
		// Create response instance
		StatusResponseDto response = new StatusResponseDto();
		response.setStatus(env.getProperty("info.success"));
		response.setMessage(env.getProperty("info.resource.deactivated.user_success"));
		
		return response;
	}

	@Override
	public UserInfoEntity findUserById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfoEntity findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<UserInfoEntity> listAllUsers(int pageNumber) {
		// TODO update the query to filter Status. Get only active users
		// Query users
		PageRequest pageable = PageRequest.of(pageNumber, 10, Sort.by(UserInfoEntity.ID).ascending());
		return repository.findAll(pageable);
	}

	@Override
	public List<UserInfoEntity> findUserByName(String name, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
