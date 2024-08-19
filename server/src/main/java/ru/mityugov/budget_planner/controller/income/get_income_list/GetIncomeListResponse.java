package ru.mityugov.budget_planner.controller.income.get_income_list;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GetIncomeListResponse {
    @Parameter(description = "Income list.")
    private List<GetIncomeResponse> incomeList;
}
