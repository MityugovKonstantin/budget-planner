package ru.mityugov.budgetplanner.infrastructure.storage

import ru.mityugov.budgetplanner.infrastructure.entity.UserEntity
import java.util.*

interface UserStorage {
    fun add(user: UserEntity)
    fun get(uuid: UUID): UserEntity
}