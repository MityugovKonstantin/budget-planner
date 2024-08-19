package ru.mityugov.budget_planner.controller.income.get_income_list;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Min;
import lombok.Data;
import org.springdoc.core.annotations.ParameterObject;

@Data
@ParameterObject
public class GetIncomeListRequest {
    @Min(message = "Page number can't be less than 0.", value = 0)
    @Parameter(description = "Page number for income list.", example = "1")
    private int pageNumber;
    @Min(message = "Page size can't be less than 1.", value = 1)
    @Parameter(description = "Page size of income entries.", example = "5")
    private int pageSize;
}
