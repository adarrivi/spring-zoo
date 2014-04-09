package com.zoo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zoo.model.Dog;

public interface DogDao extends JpaRepository<Dog, Integer> {

    @Query("from Dog where breed = :breed and age = :age")
    Dog findDogByBreedAndAge(@Param("breed") String breed, @Param("age") int age);
}
