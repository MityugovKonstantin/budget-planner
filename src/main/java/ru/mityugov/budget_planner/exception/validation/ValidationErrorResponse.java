package ru.mityugov.budget_planner.exception.validation;

import java.util.List;

public record ValidationErrorResponse(List<Violation> violations) {
}
