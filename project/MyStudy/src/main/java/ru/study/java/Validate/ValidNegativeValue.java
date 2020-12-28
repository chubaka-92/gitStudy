package ru.study.java.Validate;

import ru.study.java.Validate.ValidationException;

public class ValidNegativeValue extends ValidationException {
    public ValidNegativeValue(String description) {
        super(description);
    }
}
