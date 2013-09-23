package com.zoo.web.dto;

public class AnimalDto {

	private String name;
	private int age;

	public AnimalDto(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

}
