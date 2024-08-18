package ru.mityugov.budget_planner.service;

import ru.mityugov.budget_planner.exception.NotFoundException;
import ru.mityugov.budget_planner.service.dto.GetIncomeDto;
import ru.mityugov.budget_planner.service.dto.SaveIncomeDto;

public interface IncomeService {
    long saveIncome(SaveIncomeDto saveIncomeDto);

    GetIncomeDto getIncomeById(long id) throws NotFoundException;
}
