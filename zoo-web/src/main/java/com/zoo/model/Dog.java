package com.zoo.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Dog extends Animal {

	@Column(nullable = false)
	private String breed;

	public Dog() {
		// Used by hibernate
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

}
