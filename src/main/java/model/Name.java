package model;

import util.ExceptionMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Name {
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final Pattern pattern = Pattern.compile("^[a-zA-Z]+$");

    private final String name;

    public Name(String name) {
        validateNameLength(name);
        validateNameHasOnlyCharacters(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_NAME_LENGTH.getExceptionMessage());
        }
    }

    private void validateNameHasOnlyCharacters(String name) {
        Matcher matcher = pattern.matcher(name);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_NAME_PATTERN.getExceptionMessage());
        }
    }

    public String getName() {
        return this.name;
    }

}
