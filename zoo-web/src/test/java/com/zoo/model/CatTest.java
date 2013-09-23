package com.zoo.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CatTest {

	@Test
	public void getLives_AssignBefore_ShouldStayImmutable() {
		int numberOfLives = 3;
		List<Integer> lives = getLives(numberOfLives);
		Cat cat = new Cat();
		cat.setLives(lives);
		lives.clear();
		Assert.assertEquals(numberOfLives, cat.getLives().size());
	}

	@Test
	public void getLives_AssignAfter_ShouldStayImmutable() {
		int numberOfLives = 3;
		Cat cat = new Cat();
		cat.setLives(getLives(numberOfLives));
		List<Integer> lives = cat.getLives();
		lives.clear();
		Assert.assertEquals(numberOfLives, cat.getLives().size());
	}

	private List<Integer> getLives(int numberOfLives) {
		List<Integer> lives = new ArrayList<Integer>();
		for (int i = 0; i < numberOfLives; i++) {
			lives.add(Integer.valueOf(i));
		}
		return lives;
	}

}
