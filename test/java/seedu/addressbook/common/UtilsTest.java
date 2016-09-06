package seedu.addressbook.common;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Collection;
import java.util.ArrayList;

public class UtilsTest {
	
	/**
	 * Test isAnyNull method
	 */

	@Test
	public void isAnyNull_noArgs() {
		assertFalse(Utils.isAnyNull());
	}
	
	@Test
	public void isAnyNull_noNull() {
		assertFalse(Utils.isAnyNull(1,2,3));
	}
	
	@Test
	public void isAnyNull_hasNull() {
		assertTrue(Utils.isAnyNull(1,2,null));
	}

	/**
	 * Test elementsAreUnique method
	 */
	
	@Test
	public void elementsAreUnique_emptyCollection() {
		Collection<Object> emptyList = new ArrayList<Object>();
		assertTrue(Utils.elementsAreUnique(emptyList));
	}
	
	@Test
	public void elementsAreUnique_uniqueCollection() {
		Collection<Object> uniqueList = new ArrayList<Object>();
		uniqueList.add(1);
		uniqueList.add("a");
		uniqueList.add(false);
		assertTrue(Utils.elementsAreUnique(uniqueList));
	}
	
	@Test
	public void elementsAreUnique_duplicateCollection() {
		Collection<Object> duplicateList = new ArrayList<Object>();
		duplicateList.add(1);
		duplicateList.add("a");
		duplicateList.add("a");
		assertFalse(Utils.elementsAreUnique(duplicateList));
	}
	
}
