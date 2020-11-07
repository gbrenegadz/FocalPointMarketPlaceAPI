package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.DemoApplicationEntity;
import com.example.demo.repositories.DemoApplicationRepository;

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
