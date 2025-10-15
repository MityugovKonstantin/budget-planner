package ru.mityugov.budgetplanner.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.mityugov.budgetplanner.service.user.UserService
import ru.mityugov.budgetplanner.service.user.dto.CreateUserDto
import ru.mityugov.budgetplanner.service.user.dto.GetUserDto
import java.util.*

@RestController
@RequestMapping("/user")
class UserController @Autowired constructor(val userService: UserService) {

    @PostMapping
    fun addUser(@RequestBody name: String) {
        val user = CreateUserDto(name)
        userService.add(user)
    }

    @GetMapping("/{uuid}")
    fun getUser(@PathVariable uuid: String): GetUserDto {
        val uuid: UUID = UUID.fromString(uuid)
        return userService.get(uuid)
    }

}