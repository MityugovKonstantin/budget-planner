package ru.mityugov.budgetplanner.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mityugov.budgetplanner.infrastructure.entity.IncomeCategoryEntity
import ru.mityugov.budgetplanner.infrastructure.storage.IncomeCategoryStorage
import ru.mityugov.budgetplanner.model.IncomeCategory
import ru.mityugov.budgetplanner.service.IncomeCategoryService
import java.util.UUID

@Service
class IncomeCategoryServiceImpl @Autowired constructor(val incomeCategoryStorage: IncomeCategoryStorage) :
    IncomeCategoryService {

    override fun get(uuid: UUID): IncomeCategory {
        val incomeCategoryEntity: IncomeCategoryEntity = incomeCategoryStorage.get(uuid)
        return IncomeCategory.fromEntity(incomeCategoryEntity)
    }

    override fun create(category: IncomeCategory) {
        incomeCategoryStorage.save(category.toEntity())
    }

}