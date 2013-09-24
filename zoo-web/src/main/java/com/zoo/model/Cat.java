package com.zoo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Example class that shows how to set an immutable list inside of a Class.
 * 
 * @author alvaro
 * 
 */
public final class Cat extends Animal {

	private List<Integer> lives = new ArrayList<Integer>();

	public List<Integer> getLives() {
		return new ArrayList<Integer>(lives);
	}

	public void setLives(List<Integer> lives) {
		this.lives = new ArrayList<Integer>(lives);
	}
}
