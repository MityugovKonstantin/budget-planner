package ru.mityugov.budget_planner.validation;

import java.util.List;

public record ValidationErrorResponse(List<Violation> violations) {
}
