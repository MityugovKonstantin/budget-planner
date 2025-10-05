package ru.mityugov.budgetplanner.infrastructure.storage

import ru.mityugov.budgetplanner.infrastructure.entity.IncomeEntity
import java.time.LocalDate
import java.util.*

interface IncomeStorage {
    fun addIncome(income: IncomeEntity)
    fun getIncome(uuid: UUID): IncomeEntity
    fun getIncomes(startDate: LocalDate, endDate: LocalDate): List<IncomeEntity>
}