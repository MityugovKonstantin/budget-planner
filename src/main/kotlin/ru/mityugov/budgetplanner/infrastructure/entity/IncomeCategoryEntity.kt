package ru.mityugov.budgetplanner.infrastructure.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "income_category")
class IncomeCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null
    val uuid: UUID
    val name: String

    constructor(uuid: UUID, name: String) {
        this.uuid = uuid
        this.name = name
    }

}