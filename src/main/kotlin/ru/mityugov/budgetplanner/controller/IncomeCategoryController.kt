package ru.mityugov.budgetplanner.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import ru.mityugov.budgetplanner.model.IncomeCategory
import ru.mityugov.budgetplanner.service.IncomeCategoryService
import java.util.UUID

@Controller
@RequestMapping("/incomeCategory")
class IncomeCategoryController @Autowired constructor(val incomeCategoryService: IncomeCategoryService) {

    @GetMapping("/{uuid}")
    fun get(@PathVariable uuid: String): IncomeCategory {
        val uuid: UUID = UUID.fromString(uuid)
        return incomeCategoryService.get(uuid)
    }

    @PostMapping
    fun create(@RequestBody name: String) {
        val incomeCategory: IncomeCategory = IncomeCategory.create(name)
        incomeCategoryService.create(incomeCategory)
    }

}