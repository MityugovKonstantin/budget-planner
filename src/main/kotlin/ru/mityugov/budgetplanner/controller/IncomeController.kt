package ru.mityugov.budgetplanner.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.mityugov.budgetplanner.controller.req.CIncome
import ru.mityugov.budgetplanner.model.Income
import ru.mityugov.budgetplanner.service.income.IncomeService
import ru.mityugov.budgetplanner.service.dto.AddIncomeDto
import ru.mityugov.budgetplanner.service.income.dto.IncomeFullInfoDto
import java.time.LocalDate
import java.util.UUID

@RestController
@RequestMapping("/income")
class IncomeController @Autowired constructor(val incomeService: IncomeService) {

    @PostMapping
    fun addIncome(@RequestBody income: CIncome) {
        val income = AddIncomeDto(income)
        incomeService.addIncome(income)
    }

    @GetMapping("/{uuid}")
    fun getIncome(@PathVariable uuid: String): IncomeFullInfoDto {
        val uuid: UUID = UUID.fromString(uuid)
        return incomeService.getIncome(uuid)
    }

    @GetMapping
    fun getIncome(@RequestParam startDate: String, @RequestParam endDate: String): List<Income> {
        val startDate: LocalDate = LocalDate.parse(startDate)
        val endDate: LocalDate = LocalDate.parse(endDate)
        return incomeService.getIncomes(startDate, endDate)
    }

}