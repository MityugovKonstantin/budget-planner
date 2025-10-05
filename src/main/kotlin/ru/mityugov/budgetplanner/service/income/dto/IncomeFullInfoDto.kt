package ru.mityugov.budgetplanner.service.income.dto

import ru.mityugov.budgetplanner.model.Income
import java.time.LocalDate
import java.util.UUID

class IncomeFullInfoDto {

    val uuid: UUID
    val name: String
    val amount: Float
    val date: LocalDate
    val isDone: Boolean
    val owners: Set<UserDto>
    val categories: Set<IncomeCategoryDto>

    constructor(
        income: Income,
        owners: Set<UserDto>,
        categories: Set<IncomeCategoryDto>
    ) {
        this.uuid = income.uuid
        this.name = income.name
        this.amount = income.amount
        this.date = income.date
        this.isDone = income.isDone
        this.owners = owners
        this.categories = categories
    }

}