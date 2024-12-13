package ru.mityugov.budget_planner.service.get_income_list.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.mityugov.budget_planner.exception.NotFoundException;
import ru.mityugov.budget_planner.repository.IncomeRepository;
import ru.mityugov.budget_planner.repository.entity.IncomeEntity;
import ru.mityugov.budget_planner.service.get_income_list.IncomeService;
import ru.mityugov.budget_planner.service.get_income_list.dto.GetIncomeListDto;
import ru.mityugov.budget_planner.service.get_income_list.dto.IncomeDto;
import ru.mityugov.budget_planner.service.get_income_list.dto.SaveIncomeDto;
import ru.mityugov.budget_planner.service.get_income_list.dto.UpdateIncomeDto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
    public IncomeDto getIncomeById(long id) throws NotFoundException {
        log.debug("Start getting income by id.");

        Optional<IncomeEntity> incomeEntityOptional = incomeRepository.findById(id);

        if (incomeEntityOptional.isEmpty()) {
            String message = String.format("Income with id %d not found", id);
            log.debug(message);
            throw new NotFoundException("id", id);
        }

        IncomeEntity incomeEntity = incomeEntityOptional.get();

        String incomeDate = incomeEntity.getLocalDate().format(DateTimeFormatter.ISO_LOCAL_DATE);

        return new IncomeDto(
                incomeEntity.getId(),
                incomeEntity.getTitle(),
                incomeDate,
                incomeEntity.getAmount()
        );
    }

    @Override
    public List<IncomeDto> getIncomeList(GetIncomeListDto getIncomeListDto) {
        Pageable pageable = PageRequest.of(
                getIncomeListDto.getPageNumber(),
                getIncomeListDto.getPageSize()
        );

        Page<IncomeEntity> incomeEntityPage = incomeRepository.findAll(pageable);

        List<IncomeEntity> incomeEntityList = incomeRepository.findAll();

        return incomeEntityPage.map((element) -> new IncomeDto(
                element.getId(),
                element.getTitle(),
                element.getLocalDate().format(DateTimeFormatter.ISO_LOCAL_DATE),
                element.getAmount()
        )).toList();
    }

    @Override
    public void deleteById(long id) {
        incomeRepository.deleteById(id);
    }

    @Override
    public void update(long id, UpdateIncomeDto updateIncomeDto) throws NotFoundException {
        IncomeEntity entity = incomeRepository.findById(id).orElseThrow(() -> new NotFoundException("id", id));
        if (updateIncomeDto.getAmount() > 0) {
            entity.setAmount(updateIncomeDto.getAmount());
        }
        if (null != updateIncomeDto.getDate() && !updateIncomeDto.getDate().isBlank()) {
            LocalDate incomeLocalDate = LocalDate.parse(updateIncomeDto.getDate(), DateTimeFormatter.ISO_LOCAL_DATE);
            entity.setLocalDate(incomeLocalDate);
        }
        if (null != updateIncomeDto.getTitle() && !updateIncomeDto.getTitle().isBlank()) {
            entity.setTitle(updateIncomeDto.getTitle());
        }
        incomeRepository.save(entity);
    }
}
