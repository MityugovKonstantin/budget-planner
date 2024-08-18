package ru.mityugov.budget_planner.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SaveIncomeDto {
    private String title;
    private String date;
    private int amount;
}
