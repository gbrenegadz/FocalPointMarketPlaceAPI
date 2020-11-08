package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entities.UserInfoEntity;
import com.example.demo.repositories.UserInfoRepository;
import com.example.dto.UserInfoCreateResponseDto;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	UserInfoRepository repository;
	
	@Override
	public UserInfoCreateResponseDto createUser(UserInfoEntity user) {
		UserInfoCreateResponseDto createdUser = new UserInfoCreateResponseDto(repository.save(user));
		return createdUser;
	}

	@Override
	public UserInfoEntity updateUser(UserInfoEntity user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfoEntity removeUser(UserInfoEntity user) {
		// TODO Auto-generated method stub
		return null;
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
		PageRequest pageable = PageRequest.of(pageNumber, 10, Sort.by(UserInfoEntity.ID).ascending());
		return repository.findAll(pageable);
	}
	
	@Override
	public List<UserInfoEntity> findUserByName(String name, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
