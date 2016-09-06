package seedu.addressbook.data;

import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.*;

public class Tagging {
	public static final String ADD_TAGGING = "+";
	public static final String DELETE_TAGGING = "-";
	
	private Person person;
	private Tag tag;
	private String action;
	
	public Tagging(Person person, Tag tag, String action) {
		this.person = person;
		this.tag = tag;
		this.action = action;
	}
	
	@Override
	public String toString() {
		return action + " " + person.getName() + " " + tag.toString();
	}

}
