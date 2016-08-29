package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Aaron Ave 1, #12-34, 123456";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person address should contain block, street, unit, postal code, separated by comma and space (, )";
    public static final String ADDRESS_VALIDATION_REGEX = "(.+, ){3}.+";
    public static final String ADDRESS_COMPONENT_SEPARATOR = ", ";
    
    public static final int ADDRESS_BLOCK_INDEX = 0;
    public static final int ADDRESS_STREET_INDEX = 1;
    public static final int ADDRESS_UNIT_INDEX = 2;
    public static final int ADDRESS_POSTALCODE_INDEX = 3;

    public final String value;
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;
    
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
    		throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
    	}
        this.value = address;
        splitAddress(address);
    }
    
    /**
     * Split address into block, street, unit and postal code components and store in address object.
     * 
     * @throws IllegalValueException if given block / street / unit / postal code is invalid.
     */
    private void splitAddress(String address) throws IllegalValueException {
    	String[] addressComponents = address.split(ADDRESS_COMPONENT_SEPARATOR);
    	
    	block = new Block(addressComponents[ADDRESS_BLOCK_INDEX]);
    	street = new Street(addressComponents[ADDRESS_STREET_INDEX]);
    	unit = new Unit(addressComponents[ADDRESS_UNIT_INDEX]);
    	postalCode = new PostalCode(addressComponents[ADDRESS_POSTALCODE_INDEX]);
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

	/**
	 * @return the block
	 */
	public Block getBlock() {
		return block;
	}
	
	/**
	 * @return the street
	 */
	public Street getStreet() {
		return street;
	}
	
	/**
	 * @return the unit
	 */
	public Unit getUnit() {
		return unit;
	}
	
	/**
	 * @return the postal code
	 */
	public PostalCode getPostalCode() {
		return postalCode;
	}
}