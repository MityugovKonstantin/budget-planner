package ru.mityugov.budgetplanner.infrastructure.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.mityugov.budgetplanner.infrastructure.entity.IncomeCategoryEntity
import java.util.Optional
import java.util.UUID

@Repository
interface IncomeCategoryRepository : JpaRepository<IncomeCategoryEntity, Long> {
    fun findByUuid(uuid: UUID): Optional<IncomeCategoryEntity>
}