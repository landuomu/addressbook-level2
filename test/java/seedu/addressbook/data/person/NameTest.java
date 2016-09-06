package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {

	/**
	 * Test for isSimilar method
	 */
	
	@Test
	public void isSimilar_exactString() throws IllegalValueException {
		Name name = new Name("John Smith");
		Name exactSameName = new Name("John Smith");
		assertTrue(name.isSimilar(exactSameName));
	}
	
	@Test
	public void isSimilar_diffCase() throws IllegalValueException {
		Name name = new Name("John Smith");
		Name capsName = new Name("JOHN SMITH");
		assertTrue(name.isSimilar(capsName));
	}
	
	@Test
	public void isSimilar_extendedString() throws IllegalValueException {
		Name name = new Name("John Smith");
		Name longerName = new Name("John Kelvin Smith");
		assertTrue(name.isSimilar(longerName));
	}
	
	@Test
	public void isSimilar_shortenedString() throws IllegalValueException {
		Name name = new Name("John Smith");
		Name shorterName = new Name("John");
		assertTrue(name.isSimilar(shorterName));
	}
	
	@Test
	public void isSimilar_diffOrder() throws IllegalValueException {
		Name name = new Name("John K Smith");
		Name orderName = new Name("Smith John K");
		assertTrue(name.isSimilar(orderName));
	}

}
