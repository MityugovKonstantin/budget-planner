package ru.mityugov.budgetplanner.infrastructure.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.mityugov.budgetplanner.infrastructure.entity.UserEntity
import java.util.*

@Repository
interface UserRepository : JpaRepository<UserEntity, Long> {
    fun findByUuid(uuid: UUID): Optional<UserEntity>
}