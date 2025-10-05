package ru.mityugov.budgetplanner.service.income

import ru.mityugov.budgetplanner.model.Income
import ru.mityugov.budgetplanner.service.dto.AddIncomeDto
import ru.mityugov.budgetplanner.service.income.dto.IncomeFullInfoDto
import java.time.LocalDate
import java.util.UUID

interface IncomeService {
    fun addIncome(dto: AddIncomeDto)
    fun getIncome(uuid: UUID): IncomeFullInfoDto
    fun getIncomes(startDate: LocalDate, endDate: LocalDate): List<Income>
}