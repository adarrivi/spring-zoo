package com.zoo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zoo.service.DogService;
import com.zoo.web.dto.AnimalDto;

@Controller
public class DogListController {

    @Autowired
    private DogService dogService;

    @RequestMapping(value = { "/DogList" })
    public String welcomePage() {
        return "DogList";
    }

    @RequestMapping(value = { "/test" })
    public String welcomePage2() {
        return "DogList";
    }

    @RequestMapping(value = "getDogList", method = RequestMethod.GET)
    public @ResponseBody
    List<AnimalDto> getDogList() {
        return dogService.getAllDogsSortedByAge();
    }

    @RequestMapping(value = "saveDog", method = RequestMethod.POST)
    public String saveDog(@RequestParam String breed, @RequestParam int age) {
        dogService.saveIfDoesntExist(breed, age);
        return "DogList";
    }
}
