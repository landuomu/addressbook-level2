package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents an Address's unit in the Person's address.
 * Guarantees: immutable; is valid as declared in {@link #isValidUnit(String)}
 */
public class Unit {

    public static final String EXAMPLE = "123";
    public static final String MESSAGE_UNIT_CONSTRAINTS =
            "Address unit should start with a hex, followed by a 2 digit storey number, a dash, followed by a 2-4 digit unit number";
    public static final String UNIT_VALIDATION_REGEX = "#\\d{2}-\\d{2,4}";

    public final String value;

    /**
     * Validates given unit.
     *
     * @throws IllegalValueException if given unit string is invalid.
     */
    public Unit(String unit) throws IllegalValueException {
        if (!isValidUnit(unit)) {
            throw new IllegalValueException(MESSAGE_UNIT_CONSTRAINTS);
        }
        this.value = unit;
    }

    /**
     * Checks if a given string is a valid person email.
     */
    public static boolean isValidUnit(String test) {
        return test.matches(UNIT_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Unit // instanceof handles nulls
                && this.value.equals(((Unit) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}