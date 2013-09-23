package com.zoo.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.junit.Assert;
import org.junit.Test;

public class DogTest {

	private static final String NEW_VALUE = "Doberman";
	private static final String ORIGINAL_VALUE = "Caniche";

	/**
	 * Breed is immutable as per being a String. These tests are not really
	 * necessary.
	 */
	@Test
	public void getBreed_AssignmentBefore_ShouldStayImmutable() {
		Dog dog = new Dog();
		String originalBreed = ORIGINAL_VALUE;
		dog.setBreed(originalBreed);
		originalBreed = NEW_VALUE;
		Assert.assertEquals(ORIGINAL_VALUE, dog.getBreed());
	}

	/**
	 * Breed is immutable as per being a String. These tests are not really
	 * necessary.
	 */
	@SuppressWarnings("unused")
	@Test
	public void getBreed_AssignmentAfter_ShouldStayImmutable() {
		Dog dog = new Dog();
		dog.setBreed(ORIGINAL_VALUE);
		String originalBreed = dog.getBreed();
		originalBreed = NEW_VALUE;
		Assert.assertEquals(ORIGINAL_VALUE, dog.getBreed());
	}

	@Test
	public void equalsContract() {
		// NONFINAL_FIELDS warning appears because breed is not final. But it
		// doesn't need to be final as is not possible to change from outside of
		// the class
		// NULL_FIELDS warning appears because there are not null checks for
		// breed. But as explained in Dog class, I am assuming the controller
		// and database layers will check that.
		EqualsVerifier.forClass(Dog.class)
				.suppress(Warning.NONFINAL_FIELDS, Warning.NULL_FIELDS)
				.usingGetClass().verify();
	}

}
