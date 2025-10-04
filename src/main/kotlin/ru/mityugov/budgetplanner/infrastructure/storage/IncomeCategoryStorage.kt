package ru.mityugov.budgetplanner.infrastructure.storage

import ru.mityugov.budgetplanner.infrastructure.entity.IncomeCategoryEntity
import java.util.*

interface IncomeCategoryStorage {
    fun get(uuid: UUID): IncomeCategoryEntity
    fun save(incomeCategoryEntity: IncomeCategoryEntity)
}