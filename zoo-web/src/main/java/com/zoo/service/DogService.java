package com.zoo.service;

import java.util.List;

import com.zoo.web.dto.AnimalDto;

public interface DogService {
	List<AnimalDto> getAllDogsSortedByAge();

	void saveIfDoesntExist(String breed, int age);

}
