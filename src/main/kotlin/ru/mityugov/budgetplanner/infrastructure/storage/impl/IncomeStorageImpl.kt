package ru.mityugov.budgetplanner.infrastructure.storage.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import ru.mityugov.budgetplanner.infrastructure.entity.IncomeEntity
import ru.mityugov.budgetplanner.infrastructure.repository.IncomeRepository
import ru.mityugov.budgetplanner.infrastructure.storage.IncomeCategoryStorage
import ru.mityugov.budgetplanner.infrastructure.storage.IncomeStorage
import ru.mityugov.budgetplanner.infrastructure.storage.UserStorage
import java.time.LocalDate
import java.util.*

@Component
class IncomeStorageImpl @Autowired constructor(
    val incomeRepository: IncomeRepository,
    val userStorage: UserStorage,
    val incomeCategoryStorage: IncomeCategoryStorage
) : IncomeStorage {

    override fun addIncome(income: IncomeEntity) {
        val categoriesEntities = income.categories.map { incomeCategoryStorage.get(it.uuid) }.toMutableSet()
        val ownerEntities = income.owners.map { userStorage.get(it.uuid) }.toMutableSet()

        incomeRepository.save(income)
    }

    override fun getIncome(uuid: UUID): IncomeEntity {
        val entityOpt: Optional<IncomeEntity> = incomeRepository.findByUuid(uuid)
        return entityOpt.orElseThrow { Exception("Income not found") }
    }

    override fun getIncomes(startDate: LocalDate, endDate: LocalDate): List<IncomeEntity> {
        return incomeRepository.findIncomesByDateRange(startDate, endDate)
    }

}