package ru.mityugov.budgetplanner.service.user.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mityugov.budgetplanner.infrastructure.entity.UserEntity
import ru.mityugov.budgetplanner.infrastructure.repository.UserRepository
import ru.mityugov.budgetplanner.service.user.UserService
import ru.mityugov.budgetplanner.service.user.dto.CreateUserDto
import ru.mityugov.budgetplanner.service.user.dto.GetUserDto
import java.util.*

@Service
class UserServiceImpl(@Autowired val userRepository: UserRepository) : UserService {

    override fun add(dto: CreateUserDto) {
        val uuid: UUID = UUID.randomUUID()
        val userEntity = UserEntity(uuid = uuid, name = dto.name)
        userRepository.save(userEntity)
    }

    override fun get(uuid: UUID): GetUserDto {
        val userEntity: UserEntity = userRepository.findByUuid(uuid)
            .orElseThrow { RuntimeException("User not found with uuid: $uuid") }
        val getUserDto = GetUserDto(userEntity.uuid, userEntity.name)
        return getUserDto
    }

}