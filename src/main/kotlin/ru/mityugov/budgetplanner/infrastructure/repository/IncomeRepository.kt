package ru.mityugov.budgetplanner.infrastructure.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import ru.mityugov.budgetplanner.infrastructure.entity.IncomeEntity
import java.time.LocalDate
import java.util.*

@Repository
interface IncomeRepository : JpaRepository<IncomeEntity, Long> {
    fun findByUuid(uuid: UUID): Optional<IncomeEntity>
    @Query("select income from IncomeEntity income WHERE income.date BETWEEN :startDate AND :endDate")
    fun findIncomesByDateRange(startDate: LocalDate, endDate: LocalDate): List<IncomeEntity>
}