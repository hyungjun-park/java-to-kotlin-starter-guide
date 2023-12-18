package com.lannstark.lec15

fun main () {
    val array = arrayOf(100, 200)
    for (i in array.indices) {
        println("$i ${array[i]}")
    }

    array.plus(300)
    for ((i, v) in array.withIndex()) {
        println("$i $v")
    }

    val numbers = listOf(100, 200)
    val emptyList = emptyList<Int>()
    // 함수에서 타입을 추론하기 때문에 <타입> 생략 가능
    useNumbers(emptyList());

    // 하나 가져오기
    println(numbers[0])

    // For Each
    for (number in numbers) {
        println(number)
    }
    // 전통적인 For문 느낌 - withIndex()
    for ((index, value) in numbers.withIndex()) {
        println("$index $value")
    }
    // 가변 리스트
    val mutableNumbers = mutableListOf<Int>()

    val setNumber = setOf(100, 200)

    // Map
    val mutableMap = mutableMapOf<Int, String>()
    mutableMap[1] = "MONDAY"
    mutableMap[2] = "TUESDAY"
    // oldMap.put(3, "WEDNESDAY") // put 도 가능

    // Java의 Map.of(1, "MONDAY", 2, "TUESDAY")
    val map2 = mapOf(1 to "MONDAY", 2 to "TUESDAY")

    for (key in mutableMap.keys) {
        println("$key ${mutableMap[key]}")
    }
    for ((key, value) in mutableMap.entries) {
        println("$key $value")
    }
}

private fun useNumbers(numbers: List<Int>) {

}


