package ru.mityugov.budget_planner.controller.income;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mityugov.budget_planner.controller.income.save_income.SaveIncomeRequest;
import ru.mityugov.budget_planner.controller.income.save_income.SaveIncomeResponse;
import ru.mityugov.budget_planner.service.IncomeService;
import ru.mityugov.budget_planner.service.dto.SaveIncomeDto;

@RestController
@RequestMapping("/income")
@RequiredArgsConstructor
@Tag(name = "Income", description = "Action with incomes.")
public class IncomeController {

    private final IncomeService incomeService;

    @PostMapping
    @Operation(summary = "Save new income.")
    public SaveIncomeResponse saveIncome(@RequestBody SaveIncomeRequest request) {

        // todo - validate controller request

        SaveIncomeDto saveIncomeDto = new SaveIncomeDto(
                request.getTitle(),
                request.getDate(),
                request.getAmount()
        );
        long newIncomeId = incomeService.saveIncome(saveIncomeDto);

        return new SaveIncomeResponse(newIncomeId);
    }
}
