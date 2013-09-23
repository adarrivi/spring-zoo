package com.zoo.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.junit.Assert;
import org.junit.Test;

public class AnimalTest {

	private static final int NEW_VALUE = 2;
	private static final int ORIGINAL_VALUE = 3;

	/**
	 * Age is immutable as per being a primitive. These tests are not really
	 * necessary.
	 */
	@Test
	public void getAge_ImmutableByAssignmentBefore() {
		Animal animal = new Animal();
		int originalAge = ORIGINAL_VALUE;
		animal.setAge(originalAge);
		originalAge = NEW_VALUE;
		Assert.assertEquals(ORIGINAL_VALUE, animal.getAge());
	}

	@SuppressWarnings("unused")
	@Test
	public void getAge_ImmutableByAssignmentAfter() {
		Animal animal = new Animal();
		animal.setAge(ORIGINAL_VALUE);
		int age = animal.getAge();
		age = NEW_VALUE;
		Assert.assertEquals(ORIGINAL_VALUE, animal.getAge());
	}

	@Test
	public void equalsContract() {
		// NONFINAL_FIELDS warning appears because age is not final. But it
		// doesn't need to be final as is not possible to change from outside of
		// the class
		EqualsVerifier.forClass(Animal.class).suppress(Warning.NONFINAL_FIELDS)
				.usingGetClass().verify();
	}

}
