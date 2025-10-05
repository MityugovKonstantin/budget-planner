package ru.mityugov.budgetplanner.controller.req

import java.util.*

data class CIncome (val name: String, val amount: Float, val date: String, val isDone: Boolean,
                    val categories: Set<String>, val owners: Set<String>)