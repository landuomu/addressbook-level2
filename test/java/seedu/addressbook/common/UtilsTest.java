package seedu.addressbook.common;

import static org.junit.Assert.*;

import org.junit.Test;

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

}
