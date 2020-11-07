package com.example.demo.services;

import java.awt.print.Pageable;
import java.util.List;

import com.example.demo.entities.UserInfoEntity;
import com.example.dto.UserInfoCreateResponseDto;

public interface UserInfoService {

	public abstract UserInfoCreateResponseDto createUser(UserInfoEntity user);
	
	public abstract UserInfoEntity updateUser(UserInfoEntity user);
	
	public abstract UserInfoEntity removeUser(UserInfoEntity user);
	
	public abstract UserInfoEntity findUserById(long id);
	
	public abstract UserInfoEntity findUserByEmail(String email);
	
	public abstract List<UserInfoEntity> findUserByName(String name, Pageable pageable);
}
