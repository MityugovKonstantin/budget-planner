package ru.mityugov.budget_planner.service.get_income_list.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetIncomeListDto {
    private int pageNumber;
    private int pageSize;
}
