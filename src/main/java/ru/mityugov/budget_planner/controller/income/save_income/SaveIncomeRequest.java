package ru.mityugov.budget_planner.controller.income.save_income;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.Data;

@Data
public class SaveIncomeRequest {
    @Parameter(description = "The title of new income.", example = "Sell a table.")
    private String title;
    @Parameter(description = "The date of new income.", example = "13.07.2023")
    private String date;
    @Parameter(description = "The amount of new income.", example = "13000")
    private int amount;
}
