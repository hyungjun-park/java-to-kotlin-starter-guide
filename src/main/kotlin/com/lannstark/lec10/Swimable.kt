package com.lannstark.lec10

interface Swimable {

    val swimAbility: Int
        get() = 3

    // interface 메소드 구현 시 default 키워드 없이 구현이 가능
    fun act() {
        println("어푸 어푸")
    }
}