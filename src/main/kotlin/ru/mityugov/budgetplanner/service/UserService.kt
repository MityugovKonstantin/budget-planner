package ru.mityugov.budgetplanner.service

import ru.mityugov.budgetplanner.model.User
import java.util.UUID

interface UserService {
    fun add(user: User)
    fun get(uuid: UUID): User
}