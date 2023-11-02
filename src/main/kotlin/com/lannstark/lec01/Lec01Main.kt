package com.lannstark.lec01

fun main() {

    val nonInitNumber: Long // 타입을 지정하여 초기값 없이 사용 가능
    nonInitNumber = 1L

    // 코틀린에서는 모든 변수에 수정 가능 여부(var/val)를 명시해 주어야 한다.
    var number1: Long = 10L // 타입을 지정해주는 것도 가능
    val number2 = 10L

    // java -> Long number3 = 1_000L
    var number3: Long? = 10L // 변수에 null이 들어갈 수 있는 경우 타입? 표시를 해줘야 한다.
    number3 = null

    // 객체 인스턴스화 할 때에는 new를 붙이지 않아야 한다.
    val person = Person("홍길동")
}