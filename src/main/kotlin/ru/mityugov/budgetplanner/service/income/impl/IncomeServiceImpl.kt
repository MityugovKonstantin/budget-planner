package ru.mityugov.budgetplanner.service.income.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mityugov.budgetplanner.infrastructure.entity.IncomeEntity
import ru.mityugov.budgetplanner.infrastructure.storage.IncomeStorage
import ru.mityugov.budgetplanner.model.Income
import ru.mityugov.budgetplanner.model.IncomeCategory
import ru.mityugov.budgetplanner.model.User
import ru.mityugov.budgetplanner.service.IncomeCategoryService
import ru.mityugov.budgetplanner.service.UserService
import ru.mityugov.budgetplanner.service.dto.AddIncomeDto
import ru.mityugov.budgetplanner.service.income.IncomeService
import ru.mityugov.budgetplanner.service.income.dto.IncomeCategoryDto
import ru.mityugov.budgetplanner.service.income.dto.IncomeFullInfoDto
import ru.mityugov.budgetplanner.service.income.dto.UserDto
import java.time.LocalDate
import java.util.UUID

@Service
class IncomeServiceImpl @Autowired constructor(
    val incomeStorage: IncomeStorage,
    val userService: UserService,
    val incomeCategoryService: IncomeCategoryService
) : IncomeService {

    override fun addIncome(dto: AddIncomeDto) {
        val income = Income.create(
            dto.name,
            dto.amount,
            LocalDate.parse(dto.date),
            dto.isDone,
            dto.categories.map { UUID.fromString(it) }.toSet(),
            dto.owners.map { UUID.fromString(it) }.toSet()
        )

        userService.

        incomeStorage.addIncome(income.toEntity())
    }

    override fun getIncome(uuid: UUID): IncomeFullInfoDto {
        val incomeEntity: IncomeEntity = incomeStorage.getIncome(uuid)

        val income: Income = Income.fromEntity(incomeEntity)
        val owners: Set<User> = incomeEntity.owners.map { User.fromEntity(it) }.toSet()
        val categories: Set<IncomeCategory> = incomeEntity.categories.map { IncomeCategory.fromEntity(it) }.toSet()

        val ownerDtoSet: Set<UserDto> = owners.map { UserDto(it.uuid, it.name) }.toSet()
        val categoryDtoSet: Set<IncomeCategoryDto> = categories.map { IncomeCategoryDto(it.uuid, it.name) }.toSet()

        return IncomeFullInfoDto(income, ownerDtoSet, categoryDtoSet)
    }

    override fun getIncomes(
        startDate: LocalDate, endDate: LocalDate
    ): List<Income> {
        val incomes: List<IncomeEntity> = incomeStorage.getIncomes(startDate, endDate)
        return incomes.map { Income.Companion.fromEntity(it) }
    }

}