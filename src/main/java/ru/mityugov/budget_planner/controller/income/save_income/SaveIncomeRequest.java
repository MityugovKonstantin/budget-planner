package ru.mityugov.budget_planner.controller.income.save_income;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import ru.mityugov.budget_planner.validate.DateRegexPattern;

@Data
public class SaveIncomeRequest {
    @NotBlank(message = "Income title must be not blank.")
    @Parameter(description = "The title of new income.", example = "Sell a table.")
    private String title;

    @NotBlank(message = "Income date must be not blank.")
    @Pattern(regexp = DateRegexPattern.ISO_LOCAL_DATE, message = "Income date must match the pattern 'yyyy-MM-dd'.")
    @Parameter(description = "The date of new income.", example = "13.07.2023")
    private String date;

    @Min(message = "Income amount must be more than zero.", value = 1)
    @Parameter(description = "The amount of new income.", example = "13000")
    private int amount;
}
