package com.zoo.service.impl;

import java.util.Comparator;

import com.zoo.model.Animal;

public class AnimalComparator implements Comparator<Animal> {

	@Override
	public int compare(Animal animal1, Animal animal2) {
		// In Java 7 return Integer.compare(..);
		return Double.compare(animal1.getAge(), animal2.getAge());
	}

}
