package com.zoo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zoo.service.AnimalService;
import com.zoo.web.dto.AnimalDto;

@Controller
public class DogListController {

	@Autowired
	private AnimalService animalService;

	@RequestMapping(value = { "/DogList" })
	public String welcomePage() {
		return "DogList";
	}

	@RequestMapping(value = "getDogList", method = RequestMethod.GET)
	public @ResponseBody
	List<AnimalDto> getDogList() {
		return animalService.getAllDogs();
	}
}
