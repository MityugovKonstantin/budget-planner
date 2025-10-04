package ru.mityugov.budgetplanner.infrastructure.storage.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import ru.mityugov.budgetplanner.infrastructure.entity.UserEntity
import ru.mityugov.budgetplanner.infrastructure.repository.UserRepository
import ru.mityugov.budgetplanner.infrastructure.storage.UserStorage
import java.util.*

@Component
class UserStorageImpl(@Autowired val userRepository: UserRepository) : UserStorage {

    override fun add(user: UserEntity) {
        userRepository.save(user)
    }

    override fun get(uuid: UUID): UserEntity {
        val entityOpt: Optional<UserEntity> = userRepository.findByUuid(uuid)
        val entity: UserEntity = entityOpt.orElseThrow { Exception("User not found") }
        return entity
    }

}