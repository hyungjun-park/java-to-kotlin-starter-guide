package com.lannstark.lec07

import java.io.BufferedReader
import java.io.FileReader

fun main() {

}

// 코틀린에서는 try with resources 가 없고 use 를 사용한다.
fun readFile(path: String) {
    BufferedReader(FileReader(path)).use {
        println(it.readLine())
    }
}

fun parseIntOrThrow(str: String): Int {
    try {
        return str.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("주어진 ${str}는 숫자가 아닙니다.")
    }
}

/*
    try 문도 expression이다. -> 즉 값을 만들어 내기 때문에 바로 return
 */
fun parseIntOrThrow2(str: String): Int? {
    return try {
        str.toInt()
    } catch (e: NumberFormatException) {
        null
    }
}
