package ru.mityugov.budgetplanner.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mityugov.budgetplanner.infrastructure.entity.UserEntity
import ru.mityugov.budgetplanner.infrastructure.storage.UserStorage
import ru.mityugov.budgetplanner.model.User
import ru.mityugov.budgetplanner.service.UserService
import java.util.*

@Service
class UserServiceImpl(@Autowired val userStorage: UserStorage) : UserService {

    override fun add(user: User) {
        userStorage.add(user.toEntity())
    }

    override fun get(uuid: UUID): User {
        val userEntity: UserEntity = userStorage.get(uuid)
        return User.fromEntity(userEntity)
    }

}