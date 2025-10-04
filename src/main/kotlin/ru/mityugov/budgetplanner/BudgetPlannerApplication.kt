package ru.mityugov.budgetplanner

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EntityScan
@EnableJpaRepositories
@SpringBootApplication
class BudgetPlannerApplication

fun main(args: Array<String>) {
    runApplication<BudgetPlannerApplication>(*args)
}
