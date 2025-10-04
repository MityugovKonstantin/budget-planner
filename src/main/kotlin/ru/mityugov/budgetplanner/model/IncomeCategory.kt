package ru.mityugov.budgetplanner.model

import ru.mityugov.budgetplanner.infrastructure.entity.IncomeCategoryEntity
import java.util.*

class IncomeCategory {

    val uuid: UUID
    val name: String

    private constructor(uuid: UUID, name: String) {
        this.uuid = uuid
        this.name = name
    }

    fun toEntity(): IncomeCategoryEntity {
        return IncomeCategoryEntity(this.uuid, this.name)
    }

    companion object {

        fun create(name: String): IncomeCategory {
            return IncomeCategory(UUID.randomUUID(), name)
        }

        fun fromEntity(income: IncomeCategoryEntity): IncomeCategory {
            return IncomeCategory(income.uuid, income.name);
        }

    }
}