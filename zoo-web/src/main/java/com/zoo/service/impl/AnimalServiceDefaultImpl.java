package com.zoo.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zoo.service.AnimalService;
import com.zoo.web.dto.AnimalDto;

@Service
public class AnimalServiceDefaultImpl implements AnimalService {

	public List<AnimalDto> getAllDogs() {
		return Collections.singletonList(new AnimalDto("dog"));
	}

}
