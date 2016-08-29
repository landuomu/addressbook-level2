package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents an Address's postal code in the Person's address.
 * Guarantees: immutable; is valid as declared in {@link #isValidPostalCode(String)}
 */
public class PostalCode {

    public static final String EXAMPLE = "123";
    public static final String MESSAGE_POSTALCODE_CONSTRAINTS =
            "Address postal code should be 6 digits";
    public static final String POSTALCODE_VALIDATION_REGEX = "\\d{6}";

    public final String value;

    /**
     * Validates given postal code.
     *
     * @throws IllegalValueException if given postalCode string is invalid.
     */
    public PostalCode(String postalCode) throws IllegalValueException {
        if (!isValidPostalCode(postalCode)) {
            throw new IllegalValueException(MESSAGE_POSTALCODE_CONSTRAINTS);
        }
        this.value = postalCode;
    }

    /**
     * Checks if a given string is a valid person email.
     */
    public static boolean isValidPostalCode(String test) {
        return test.matches(POSTALCODE_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PostalCode // instanceof handles nulls
                && this.value.equals(((PostalCode) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}