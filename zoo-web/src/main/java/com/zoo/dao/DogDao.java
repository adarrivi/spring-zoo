package com.zoo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoo.model.Dog;

@Repository
public interface DogDao extends JpaRepository<Dog, Integer> {

	// Nothing to implement
}
