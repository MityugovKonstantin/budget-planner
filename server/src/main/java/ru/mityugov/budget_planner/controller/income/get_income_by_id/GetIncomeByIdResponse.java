package ru.mityugov.budget_planner.controller.income.get_income_by_id;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetIncomeByIdResponse {
    @Parameter(description = "Income database id.", example = "1")
    private long id;
    @Parameter(description = "Title of income.", example = "Sell old book.")
    private String title;
    @Parameter(description = "Planed date of income.", example = "2024-04-14")
    private String date;
    @Parameter(description = "Amount of income.", example = "150")
    private int amount;
}
