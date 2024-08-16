package ru.mityugov.budget_planner.service;

import ru.mityugov.budget_planner.service.dto.SaveIncomeDto;

public interface IncomeService {
    long saveIncome(SaveIncomeDto saveIncomeDto);
}
