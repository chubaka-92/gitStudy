package ru.study.java.Validate;

import ru.study.java.Validate.ValidationException;

public class ValidEmptyValue extends ValidationException {
    public ValidEmptyValue(String description) {
        super(description);
    }

}
