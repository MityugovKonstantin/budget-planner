package ru.mityugov.budgetplanner.model

import ru.mityugov.budgetplanner.infrastructure.entity.UserEntity
import java.util.*

class User {

    val uuid: UUID
    val name: String

    private constructor(uuid: UUID, name: String) {
        this.uuid = uuid
        this.name = name
    }

    fun toEntity(): UserEntity {
        return UserEntity(this.uuid, this.name)
    }

    companion object {

        fun create(name: String): User {
            return User(UUID.randomUUID(), name)
        }

        fun fromEntity(income: UserEntity): User {
            return User(income.uuid, income.name);
        }

    }

}