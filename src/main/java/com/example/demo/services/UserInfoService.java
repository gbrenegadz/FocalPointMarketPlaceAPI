package com.example.demo.services;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

import com.example.demo.entities.UserInfoEntity;
import com.example.dto.UserInfoCreateResponseDto;

public interface UserInfoService {

	public abstract UserInfoCreateResponseDto createUser(UserInfoEntity user);
	
	public abstract UserInfoEntity updateUser(UserInfoEntity user);
	
	public abstract UserInfoEntity removeUser(UserInfoEntity user);
	
	public abstract UserInfoEntity findUserById(long id);
	
	public abstract UserInfoEntity findUserByEmail(String email);
	
	public abstract Page<UserInfoEntity> listAllUsers(int pageNumber);
	
	public abstract List<UserInfoEntity> findUserByName(String name, Pageable pageable);
}
