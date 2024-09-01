package ru.mityugov.budget_planner.controller.income;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.mityugov.budget_planner.controller.income.delete.DeleteIncomeResponse;
import ru.mityugov.budget_planner.controller.income.get_income_by_id.GetIncomeByIdResponse;
import ru.mityugov.budget_planner.controller.income.get_income_list.GetIncomeListRequest;
import ru.mityugov.budget_planner.controller.income.get_income_list.GetIncomeResponse;
import ru.mityugov.budget_planner.controller.income.save_income.SaveIncomeRequest;
import ru.mityugov.budget_planner.controller.income.save_income.SaveIncomeResponse;
import ru.mityugov.budget_planner.controller.income.update.UpdateIncomeRequest;
import ru.mityugov.budget_planner.controller.income.update.UpdateIncomeResponse;
import ru.mityugov.budget_planner.exception.NotFoundException;
import ru.mityugov.budget_planner.service.get_income_list.IncomeService;
import ru.mityugov.budget_planner.service.get_income_list.dto.GetIncomeListDto;
import ru.mityugov.budget_planner.service.get_income_list.dto.IncomeDto;
import ru.mityugov.budget_planner.service.get_income_list.dto.SaveIncomeDto;
import ru.mityugov.budget_planner.service.get_income_list.dto.UpdateIncomeDto;

import java.util.List;

@Validated
@CrossOrigin
@RestController
@RequestMapping("/income")
@RequiredArgsConstructor
@Tag(name = "Income", description = "Action with incomes.")
public class IncomeController {

    private final IncomeService incomeService;

    @PostMapping
    @Operation(summary = "Save new income.")
    public SaveIncomeResponse saveIncome(@Valid @RequestBody SaveIncomeRequest request) {

        SaveIncomeDto saveIncomeDto = new SaveIncomeDto(
                request.getTitle(),
                request.getDate(),
                request.getAmount()
        );
        long newIncomeId = incomeService.saveIncome(saveIncomeDto);

        return new SaveIncomeResponse(newIncomeId);
    }

    @GetMapping(path = "/{id}")
    @Operation(summary = "Get income by id.")
    public GetIncomeByIdResponse getIncomeById(
            @PathVariable("id")
            @Parameter(description = "Income id.", example = "1")
            @Min(message = "Income id can't be less than 1.", value = 1)
            long id
    ) throws NotFoundException {
        IncomeDto incomeDto = incomeService.getIncomeById(id);
        return new GetIncomeByIdResponse(
                incomeDto.getId(),
                incomeDto.getTitle(),
                incomeDto.getDate(),
                incomeDto.getAmount()
        );
    }

    @GetMapping(path = "/list")
    @Operation(summary = "Get incomes.")
    public List<GetIncomeResponse> getIncomeList(@Valid GetIncomeListRequest request) {
        GetIncomeListDto getIncomeListDto = new GetIncomeListDto(request.getPageNumber(), request.getPageSize());
        List<IncomeDto> incomeList = incomeService.getIncomeList(getIncomeListDto);
        return incomeList.stream()
                .map((dto) -> new GetIncomeResponse(dto.getId(), dto.getTitle()))
                .toList();
    }

    @DeleteMapping(path = "/{id}")
    @Operation(summary = "Delete income by id.")
    public DeleteIncomeResponse deleteIncomeById(
            @Valid
            @PathVariable("id")
            @Parameter(description = "Income id.", example = "1")
            @Min(message = "Income id can't be less than 1.", value = 1)
            long id
    ) {
        incomeService.deleteById(id);
        return new DeleteIncomeResponse("Income was deleted.");
    }

    @PostMapping(path = "/{id}")
    @Operation(summary = "Update income.")
    public UpdateIncomeResponse updateIncomeById(
            @Valid
            @PathVariable("id")
            @Parameter(description = "Income id.", example = "1")
            @Min(message = "Income id can't be less than 1.", value = 1)
            long id,
            @Valid
            @RequestBody
            UpdateIncomeRequest request
    ) throws NotFoundException {
        UpdateIncomeDto updateIncomeDto = new UpdateIncomeDto(
                request.getTitle(),
                request.getDate(),
                request.getAmount()
        );
        incomeService.update(id, updateIncomeDto);
        return new UpdateIncomeResponse("Income was updated.");
    }
}
