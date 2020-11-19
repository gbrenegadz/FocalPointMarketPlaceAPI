package com.bizepic.focal_point_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bizepic.focal_point_api.common.entities.DemoApplicationEntity;
import com.bizepic.focal_point_api.repositories.DemoApplicationRepository;

/**
 * 
 * @author Gilbert Renegado
 *
 */
@Service
public class DemoApplicationServiceImpl implements DemoApplicationService {

	@Autowired
	DemoApplicationRepository repository;
	
	@Override
	public String displayMessage(String message) {
		List<DemoApplicationEntity> entities = repository.findAll();
		if (entities != null) {
			System.err.println("Entities Size: " + entities.size());
		}
		
		DemoApplicationEntity entity = repository.findByMessage(message);
		if (entity == null) {
			return "Wala koy nakit-an uy";
		}
		
		return entity.getMessage();
	}

}
