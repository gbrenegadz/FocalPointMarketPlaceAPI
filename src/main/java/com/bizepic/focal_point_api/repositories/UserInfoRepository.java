package com.bizepic.focal_point_api.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bizepic.focal_point_api.common.entities.UserInfoEntity;

/**
 * 
 * @author Gilbert Renegado
 *
 */
public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Long> {

	@Transactional
	@Query(value="SELECT * FROM GILBERT_P_RENEGADO.USER_INFO WHERE ID = ?", nativeQuery=true)
	UserInfoEntity findByUserId(Long id);
}
