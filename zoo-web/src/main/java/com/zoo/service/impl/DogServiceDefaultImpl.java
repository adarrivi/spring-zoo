package com.zoo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zoo.dao.DogDao;
import com.zoo.model.Dog;
import com.zoo.service.DogService;
import com.zoo.web.dto.AnimalDto;

@Service
@Transactional(readOnly = true)
public class DogServiceDefaultImpl implements DogService {

	@Autowired
	private DogDao dogDao;

	@Override
	public List<AnimalDto> getAllDogs() {
		List<Dog> allDogs = dogDao.findAll();
		return transformToDto(allDogs);
	}

	private List<AnimalDto> transformToDto(List<Dog> dogs) {
		List<AnimalDto> dtoList = new ArrayList<AnimalDto>();
		for (Dog dog : dogs) {
			dtoList.add(new AnimalDto(dog.getBreed(), dog.getAge()));
		}
		return dtoList;

	}

	@Override
	@Transactional
	public void saveIfDoesntExist(String breed, int age) {
		Dog existingDog = dogDao.findDogByBreedAndAge(breed, age);
		if (existingDog == null) {
			saveNewDog(breed, age);
		}
	}

	private void saveNewDog(String breed, int age) {
		Dog dog = new Dog();
		dog.setAge(age);
		dog.setBreed(breed);
		dogDao.save(dog);
	}

}
