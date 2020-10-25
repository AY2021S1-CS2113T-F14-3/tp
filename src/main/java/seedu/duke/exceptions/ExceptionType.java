package seedu.duke.exceptions;

import seedu.duke.favorite.FavList;

public enum ExceptionType {
    INVALID_COMMAND("I do not understand!!"),
    INVALID_BUS("Sorry,there is no such bus in our database!"),
    NO_ROUTE_DELIMITER("Oops! You are missing the delimiter."),
    NO_LOCATIONS("Oh dear! I don't have all locations."),
    MISSING_BUS_CODE("Oh no! You seem to have missed typing in the bus code!"),
    SAME_LOCATIONS("You don't need a bus to get there...You are right there!"),
    INVALID_BUS_STOP("Oh no! I do not understand which bus stop you are looking for"),
    INVALID_FACULTY("Oh no! Please enter a faculty."),
    INVALID_FOODPLACE("Oh no! I cannot detect any inputs."),
    UPDATE_FILE_FAIL("Sorry to inform you that the update of frequency list is unsuccessful."),
    READ_FILE_FAIL("It is unfortunate that the program is unable to read the file"),
    INDEX_NOT_IN_RANGE("The number you have keyed in is out of range!"),
    EMPTY_INDEX("Kindly input a valid index");

    private String message;

    ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
