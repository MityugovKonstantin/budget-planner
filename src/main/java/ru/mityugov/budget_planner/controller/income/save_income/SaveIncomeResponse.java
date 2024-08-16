package ru.mityugov.budget_planner.controller.income.save_income;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SaveIncomeResponse {
    @Parameter(description = "New income id.", example = "1")
    private long id;
}
