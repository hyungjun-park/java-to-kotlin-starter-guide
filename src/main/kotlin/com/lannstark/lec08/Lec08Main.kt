package com.lannstark.lec08

import javax.swing.JTable.PrintMode

fun main() {
    // named argument
    // build 를 만들지 않고 build의 장점을 가질 수 있다.
    // Java 함수를 사용 할 경우는 named argument 를 사용할 수 없다.
    repeat("Hello~", userNewLine = true)

    printNameAndGender(name = "홍길동", gender = "홍홍")

    // 가변 인자
    printAll("a", "b", "c")

    val arr = arrayOf("a", "b", "c")
    // 배열의 경우 *(spread 연산자) 사용
    // 배열 안에 있는 것들을 마치 그냥 ,를 쓰는 것처럼 꺼내준다.
    printAll(*arr)
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}
// fun max(a: Int, b: Int) = return if (a > b) a else b

// default parameter
// 코틀린에서도 오버로딩, 오버라이딩도 가능하다.
fun repeat(
    str: String,
    num: Int = 3,
    userNewLine: Boolean = true,
) {
    for (i in 1 .. num) {
        if (userNewLine) {
            println(str)
        } else {
            print(str)
        }
    }
}

fun printNameAndGender(name: String, gender: String) {
    println(name)
    println(gender)
}

// 가변인가 함수
fun printAll(vararg strings: String) {
    for (str in strings) {
        println(str)
    }
}