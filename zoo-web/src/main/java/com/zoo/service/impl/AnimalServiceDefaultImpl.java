package com.zoo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zoo.dao.DogDao;
import com.zoo.model.Animal;
import com.zoo.model.Dog;
import com.zoo.service.AnimalService;
import com.zoo.web.dto.AnimalDto;

@Service
@Transactional(readOnly = true)
public class AnimalServiceDefaultImpl implements AnimalService {

	@Autowired
	private DogDao dogDao;

	@Override
	@Transactional
	public List<AnimalDto> getAllDogs() {
		List<AnimalDto> dtoList = new ArrayList<AnimalDto>();
		List<Dog> allDogs = dogDao.findAll();
		for (Animal dog : allDogs) {
			dtoList.add(new AnimalDto(dog.getId().toString()));
		}
		return dtoList;
	}

}
