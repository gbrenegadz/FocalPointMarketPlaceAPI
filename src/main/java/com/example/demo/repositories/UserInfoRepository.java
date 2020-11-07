package com.example.demo.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.UserInfoEntity;


public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Long> {

	@Transactional
	@Query(value="SELECT * FROM GILBERT_P_RENEGADO.USER_INFO WHERE MESSAGE = :id", nativeQuery=true)
	List<UserInfoEntity> findById(long id);
}
