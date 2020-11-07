package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.DemoApplicationEntity;

public interface DemoApplicationRepository extends JpaRepository<DemoApplicationEntity, Long> {

	@Transactional
	@Query(value="SELECT * FROM gilbert_p_renegado.MESSAGE WHERE MESSAGE = :message", nativeQuery=true)
	DemoApplicationEntity findByMessage(@Param("message") String message);
}
