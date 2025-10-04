package ru.mityugov.budgetplanner.infrastructure.storage.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import ru.mityugov.budgetplanner.infrastructure.entity.IncomeCategoryEntity
import ru.mityugov.budgetplanner.infrastructure.repository.IncomeCategoryRepository
import ru.mityugov.budgetplanner.infrastructure.storage.IncomeCategoryStorage
import java.util.*

@Component
class IncomeCategoryStorageImpl @Autowired constructor(val incomeCategoryRepository: IncomeCategoryRepository) :
    IncomeCategoryStorage {

    override fun get(uuid: UUID): IncomeCategoryEntity {
        val entityOpt: Optional<IncomeCategoryEntity> = incomeCategoryRepository.findByUuid(uuid)
        val entity: IncomeCategoryEntity = entityOpt.orElseThrow { Exception("Income category not found") }
        return entity
    }

    override fun save(incomeCategoryEntity: IncomeCategoryEntity) {
        incomeCategoryRepository.save(incomeCategoryEntity);
    }
}