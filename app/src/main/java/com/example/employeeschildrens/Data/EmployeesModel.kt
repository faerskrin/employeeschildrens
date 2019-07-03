package com.example.employeeschildrens.Data

import java.util.*

data class Employees(
        val id: UUID,
        val lastname: String,
        val name: String,
        val middlename: String,
        val birthday: String,
        val position: String,
        var childrens : List<Childrens>?
)

data class Childrens(
        var lastname: String,
        var name: String,
        var middlename: String,
        var birthday: String
)