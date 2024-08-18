package ru.mityugov.budget_planner.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mityugov.budget_planner.exception.NotFoundException;
import ru.mityugov.budget_planner.repository.IncomeRepository;
import ru.mityugov.budget_planner.repository.entity.IncomeEntity;
import ru.mityugov.budget_planner.service.IncomeService;
import ru.mityugov.budget_planner.service.dto.GetIncomeDto;
import ru.mityugov.budget_planner.service.dto.SaveIncomeDto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Slf4j
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

    @Override
    public GetIncomeDto getIncomeById(long id) throws NotFoundException {
        log.debug("Start getting income by id.");

        Optional<IncomeEntity> incomeEntityOptional = incomeRepository.findById(id);

        if (incomeEntityOptional.isEmpty()) {
            String message = String.format("Income with id %d not found", id);
            log.debug(message);
            throw new NotFoundException("id", id);
        }

        IncomeEntity incomeEntity = incomeEntityOptional.get();

        String incomeDate = incomeEntity.getLocalDate().format(DateTimeFormatter.ISO_LOCAL_DATE);

        return new GetIncomeDto(
                incomeEntity.getId(),
                incomeEntity.getTitle(),
                incomeDate,
                incomeEntity.getAmount()
        );
    }
}
