package ru.mityugov.budget_planner.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mityugov.budget_planner.repository.IncomeRepository;
import ru.mityugov.budget_planner.repository.entity.IncomeEntity;
import ru.mityugov.budget_planner.service.IncomeService;
import ru.mityugov.budget_planner.service.dto.SaveIncomeDto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {

    private final IncomeRepository incomeRepository;

    @Override
    public long saveIncome(SaveIncomeDto saveIncomeDto) {

        LocalDate incomeLocalDate = LocalDate.parse(saveIncomeDto.getDate(), DateTimeFormatter.ISO_LOCAL_DATE);

        IncomeEntity incomeEntity = new IncomeEntity();
        incomeEntity.setTitle(saveIncomeDto.getTitle());
        incomeEntity.setLocalDate(incomeLocalDate);
        incomeEntity.setAmount(saveIncomeDto.getAmount());

        IncomeEntity resultIncomeEntity = incomeRepository.save(incomeEntity);

        return resultIncomeEntity.getId();
    }
}
