package com.zoo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.zoo.dao.DogDao;
import com.zoo.model.Dog;
import com.zoo.service.DogService;
import com.zoo.web.dto.AnimalDto;

public class DogServiceDefaultImplTest {

	private static final String DOG_BREED = "Golden";
	private static final int DOG_AGE = 3;

	@Mock
	private DogDao dogDao;

	private List<Dog> dogList;
	private List<AnimalDto> animalListResult;

	@InjectMocks
	private DogService victim = new DogServiceDefaultImpl();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllDogs_NoDogsFound_ReturnEmptyList() {
		givenNoDogsFound();
		whenGetAllDogs();
		thenResultShouldBeEmpty();
	}

	private void givenNoDogsFound() {
		dogList = new ArrayList<Dog>();
		Mockito.when(dogDao.findAll()).thenReturn(dogList);
	}

	private void whenGetAllDogs() {
		animalListResult = victim.getAllDogsSortedByAge();
	}

	private void thenResultShouldBeEmpty() {
		Assert.assertTrue(animalListResult.isEmpty());
	}

	@Test
	public void getAllDogs_DogFound_ReturnDogList() {
		givenDogFound();
		whenGetAllDogs();
		thenResultShouldNotBeEmpty();
	}

	private void givenDogFound() {
		dogList = new ArrayList<Dog>();
		Dog dog = new Dog();
		dog.setAge(Integer.valueOf(DOG_AGE));
		dog.setBreed(DOG_BREED);
		dogList.add(dog);
		Mockito.when(dogDao.findAll()).thenReturn(dogList);
	}

	private void thenResultShouldNotBeEmpty() {
		Assert.assertFalse(animalListResult.isEmpty());
	}

	@Test
	public void getAllDogs_DogFound_ReturnDogBreedAsName() {
		givenDogFound();
		whenGetAllDogs();
		thenResultAnimalNameShouldBe(DOG_BREED);
	}

	private void thenResultAnimalNameShouldBe(String expectedName) {
		thenResultShouldNotBeEmpty();
		Assert.assertEquals(expectedName, animalListResult.get(0).getName());
	}

	@Test
	public void getAllDogs_DogFound_ReturnDogAgeAsAge() {
		givenDogFound();
		whenGetAllDogs();
		thenResultAnimalAgeShouldBe(DOG_AGE);
	}

	private void thenResultAnimalAgeShouldBe(int expectedAge) {
		thenResultShouldNotBeEmpty();
		Assert.assertEquals(expectedAge, animalListResult.get(0).getAge());
	}

}
