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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		// Not considering breed nullable, as below (database) and above
		// (controller) there are restrictions to it
		result = prime * result + getBreed().hashCode();
		return result;
	}

	// Using getClass() to remove the inheritance from equality. Only Dogs vs
	// Dogs are allowed in the equality, as defining equals in both superclass
	// and subclass creates lots of problems.
	// See http://www.artima.com/lejava/articles/equality.html
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Dog other = (Dog) obj;
		return getBreed().equals(other.getBreed());
	}

}
