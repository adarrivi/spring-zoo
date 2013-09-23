package com.zoo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoo.model.Animal;

@Repository
public interface AnimalDao extends JpaRepository<Animal, Integer> {

	// Nothing to implement
}
