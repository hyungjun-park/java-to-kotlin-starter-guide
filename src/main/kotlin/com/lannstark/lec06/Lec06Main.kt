package com.lannstark.lec06

import javax.xml.transform.dom.DOMResult

fun main() {

    for (i in 1..3) {
        println(i)
    }

    for (i in 3 downTo 1) {
        println(i)
    }

    // 1부터 5까지 2씩 증가
    for (i in 1 .. 5 step 2) {
        println(i)
    }

    // while 문은 java 와 동일
    var i = 1
    while (i <= 3) {
        println(i)
        i++
    }
}