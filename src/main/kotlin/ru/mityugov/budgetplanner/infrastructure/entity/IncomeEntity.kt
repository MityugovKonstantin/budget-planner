package ru.mityugov.budgetplanner.infrastructure.entity

import jakarta.persistence.*
import java.time.LocalDate
import java.util.*

@Entity
@Table(name = "income")
class IncomeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null
    val name: String
    val uuid: UUID
    val amount: Float
    val date: LocalDate
    val isDone: Boolean
    @ManyToMany
    @JoinTable(
        name = "category_income_link",
        joinColumns = [JoinColumn(name = "income_id")],
        inverseJoinColumns = [JoinColumn(name = "category_id")]
    )
    val categories: MutableSet<IncomeCategoryEntity>
    @ManyToMany
    @JoinTable(
        name = "user_income_link",
        joinColumns = [JoinColumn(name = "income_id")],
        inverseJoinColumns = [JoinColumn(name = "user_id")]
    )
    val owners: MutableSet<UserEntity>

    constructor(
        uuid: UUID,
        name: String,
        amount: Float,
        date: LocalDate,
        isDone: Boolean,
        categories: MutableSet<IncomeCategoryEntity>,
        owners: MutableSet<UserEntity>
    ) {
        this.name = name
        this.amount = amount
        this.date = date
        this.isDone = isDone
        this.categories = categories
        this.owners = owners
        this.uuid = uuid
    }

}