package ru.mityugov.budget_planner.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends Exception {
    private final String fieldName;

    public NotFoundException(String fieldName, Object fieldValue) {
        super(String.format("Object with %s = '%s' not found.", fieldName, fieldValue));
        this.fieldName = fieldName;
    }
}
