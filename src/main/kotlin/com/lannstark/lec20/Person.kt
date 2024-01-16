package com.lannstark.lec20

class Person (
    val name: String,
    val age: Int,
) {
    lateinit var hobby: String

    val isAdult: Boolean
        get() = age >= 20
}