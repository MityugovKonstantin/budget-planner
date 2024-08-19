package ru.mityugov.budget_planner.service.get_income_list;

import ru.mityugov.budget_planner.exception.NotFoundException;
import ru.mityugov.budget_planner.service.get_income_list.dto.GetIncomeListDto;
import ru.mityugov.budget_planner.service.get_income_list.dto.IncomeDto;
import ru.mityugov.budget_planner.service.get_income_list.dto.SaveIncomeDto;

import java.util.List;

public interface IncomeService {
    long saveIncome(SaveIncomeDto saveIncomeDto);

    IncomeDto getIncomeById(long id) throws NotFoundException;

    List<IncomeDto> getIncomeList(GetIncomeListDto getIncomeListDto);
}
