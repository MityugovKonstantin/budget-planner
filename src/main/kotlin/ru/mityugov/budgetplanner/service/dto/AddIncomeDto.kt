package ru.mityugov.budgetplanner.service.dto

import ru.mityugov.budgetplanner.controller.req.CIncome

class AddIncomeDto {

    val name: String
    val amount: Float
    val date: String
    val isDone: Boolean
    val owners: Set<String>
    val categories: Set<String>

    constructor(income: CIncome) {
        this.name = income.name
        this.amount = income.amount
        this.date = income.date
        this.isDone = income.isDone
        this.owners = income.owners
        this.categories = income.categories
    }
}