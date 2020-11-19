package com.bizepic.focal_point_api.services;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

import com.bizepic.focal_point_api.common.entities.UserInfoEntity;
import com.bizepic.focal_point_api.common.exceptions.CustomResourceException;
import com.bizepic.focal_point_api.dto.StatusResponseDto;
import com.bizepic.focal_point_api.dto.UserInfoCreateRequestDto;
import com.bizepic.focal_point_api.dto.UserInfoResponseDto;
import com.bizepic.focal_point_api.dto.UserInfoUpdateRequestDto;

/**
 * 
 * @author Gilbert Renegado
 *
 */
public interface UserInfoService {

	public abstract UserInfoResponseDto createUser(UserInfoCreateRequestDto request);
	
	public abstract UserInfoResponseDto updateUser(UserInfoUpdateRequestDto user);
	
	public abstract StatusResponseDto deactivateUser(Long user) throws CustomResourceException;
	
	public abstract UserInfoEntity findUserById(long id);
	
	public abstract UserInfoEntity findUserByEmail(String email);
	
	public abstract Page<UserInfoEntity> listAllUsers(int pageNumber);
	
	public abstract List<UserInfoEntity> findUserByName(String name, Pageable pageable);
}
