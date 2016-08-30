package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.*;

import java.util.List;

public class Formatter {

	/** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    public static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";
    
    public static String formatToUserMessage(String... message) {
    	final StringBuilder formatted = new StringBuilder();
        for (String m : message) {
            formatted.append(addLinePrefixAndSeparator(m)).append("\n");
        }
        return formatted.toString();
    }
    
    public static String addLinePrefix(String message) {
    	return LINE_PREFIX + message;
    }
    
    private static String addLinePrefixAndNewline() {
    	return LINE_PREFIX + "\n";
    }
    
    public static String addLinePrefixAndSeparator(String message) {
    	return LINE_PREFIX + message.replace("\n", LS + LINE_PREFIX);
    }
    
    public static String addCommandWrapper(String message) {
    	return LINE_PREFIX + "[Command entered:" + message + "]" + "\n";
    }
    
    /** Formats a list of strings as a viewable indexed list. */
    public static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + TextUi.DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(addLinePrefixAndSeparator(getIndexedListItem(displayIndex, listItem))).append("\n");
            displayIndex++;
        }
        formatted.append(addLinePrefixAndNewline());
        return formatted.toString();
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
	
}
