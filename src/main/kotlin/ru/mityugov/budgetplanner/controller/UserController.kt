package ru.mityugov.budgetplanner.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.mityugov.budgetplanner.model.User
import ru.mityugov.budgetplanner.service.UserService
import java.util.UUID

@RestController
@RequestMapping("/user")
class UserController @Autowired constructor(val userService: UserService) {

    @PostMapping
    fun addUser(@RequestBody user: String) {
        val user = User(user)
        userService.add(user)
    }

    @GetMapping("/{uuid}")
    fun getUser(@PathVariable uuid: String): User {
        val uuid: UUID = UUID.fromString(uuid)
        return userService.get(uuid)
    }

}