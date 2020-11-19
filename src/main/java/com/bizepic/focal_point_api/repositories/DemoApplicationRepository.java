package com.bizepic.focal_point_api.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bizepic.focal_point_api.common.entities.DemoApplicationEntity;

/**
 * 
 * @author Gilbert Renegado
 *
 */
public interface DemoApplicationRepository extends JpaRepository<DemoApplicationEntity, Long> {

	@Transactional
	@Query(value="SELECT * FROM gilbert_p_renegado.MESSAGE WHERE MESSAGE = :message", nativeQuery=true)
	DemoApplicationEntity findByMessage(@Param("message") String message);
}
