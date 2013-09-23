package com.zoo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zoo.dao.AnimalDao;
import com.zoo.model.Animal;
import com.zoo.service.AnimalService;
import com.zoo.web.dto.AnimalDto;

@Service
@Transactional(readOnly = true)
public class AnimalServiceDefaultImpl implements AnimalService {

	@Autowired
	private AnimalDao animalDao;

	@Override
	@Transactional
	public List<AnimalDto> getAllDogs() {
		List<AnimalDto> dtoList = new ArrayList<AnimalDto>();
		List<Animal> allAnimals = animalDao.findAll();
		for (Animal animals : allAnimals) {
			dtoList.add(new AnimalDto(animals.getId().toString()));
		}
		return dtoList;
	}

}
