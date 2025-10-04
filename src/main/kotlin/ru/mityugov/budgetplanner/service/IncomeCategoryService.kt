package ru.mityugov.budgetplanner.service

import ru.mityugov.budgetplanner.model.IncomeCategory
import java.util.UUID

interface IncomeCategoryService {
    fun get(uuid: UUID): IncomeCategory
    fun create(category: IncomeCategory)
}