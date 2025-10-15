package ru.mityugov.budgetplanner.service.user

import ru.mityugov.budgetplanner.service.user.dto.CreateUserDto
import ru.mityugov.budgetplanner.service.user.dto.GetUserDto
import java.util.*

interface UserService {
    fun add(dto: CreateUserDto)
    fun get(uuid: UUID): GetUserDto
}