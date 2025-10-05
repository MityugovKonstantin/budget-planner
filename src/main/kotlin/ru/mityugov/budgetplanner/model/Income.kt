package ru.mityugov.budgetplanner.model

import ru.mityugov.budgetplanner.infrastructure.entity.IncomeCategoryEntity
import ru.mityugov.budgetplanner.infrastructure.entity.IncomeEntity
import ru.mityugov.budgetplanner.infrastructure.entity.UserEntity
import java.time.LocalDate
import java.util.*

class Income {

    val uuid: UUID
    val name: String
    val amount: Float
    val date: LocalDate
    val isDone: Boolean
    val owners: Set<UUID>
    val categories: Set<UUID>

    private constructor(
        uuid: UUID,
        name: String,
        amount: Float,
        date: LocalDate,
        isDone: Boolean,
        categories: Set<UUID>,
        owners: Set<UUID>
    ) {
        this.name = name
        this.amount = amount
        this.date = date
        this.isDone = isDone
        this.categories = categories
        this.owners = owners
        this.uuid = uuid
    }

    fun toEntity(categoryEntities: MutableSet<IncomeCategoryEntity>, ownerEntities: MutableSet<UserEntity>): IncomeEntity {
        return IncomeEntity(uuid, name, amount, date, isDone, categoryEntities, ownerEntities)
    }

    companion object {

        fun create(
            name: String,
            amount: Float,
            date: LocalDate,
            isDone: Boolean,
            categories: Set<UUID>,
            owners: Set<UUID>
        ): Income {
            return Income(UUID.randomUUID(), name, amount, date, isDone, categories, owners)
        }

        fun fromEntity(income: IncomeEntity): Income {
            val categories: Set<UUID> = income.categories.map { it.uuid }.toSet()
            val owners: Set<UUID> = income.owners.map { it.uuid }.toSet()
            return Income(income.uuid, income.name, income.amount, income.date, income.isDone, categories, owners)
        }

    }

}