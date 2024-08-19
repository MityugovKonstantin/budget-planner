package ru.mityugov.budget_planner.controller.income.get_income_list;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetIncomeResponse {
    @Parameter(description = "Income database id.", example = "1")
    private long id;
    @Parameter(description = "Title of income.", example = "Sell old book.")
    private String title;
}
