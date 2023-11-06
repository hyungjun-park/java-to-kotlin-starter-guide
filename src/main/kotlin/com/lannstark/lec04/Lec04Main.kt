package com.lannstark.lec04

fun main() {
    /**
        java 에서는 동일성에 ==, 동등성에 equals 호출
        kotlin 에서는 동일성에 ===, 동등성에 ==를 호출 ==를 호출하면 equals 를 호출해 준다.
     */
    val money1 = JavaMoney(1_000L)
    val money2 = money1
    val money3 = JavaMoney(1_000L)
    println(money1 == money3) // true

    // 비교 연산자
    // 객체를 비교할때 비교 연산자(>, <, >=, <=) 사용 시 자동으로 compareTo를 호출해 준다.
    val money4 = JavaMoney(1_000L)
    val money5 = JavaMoney(3_000L)
    if (money4 > money5) {
        println("Money4가 Money5 보다 크다")
    }
}