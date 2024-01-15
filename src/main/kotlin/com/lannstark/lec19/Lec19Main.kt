package com.lannstark.lec19

// as import
// 같은 함수의 이름을 변경하여 한 파일에서 사용 항 수 있다.
import com.lannstark.lec19.a.printHelloWorld as printHelloWorldA
import com.lannstark.lec19.b.printHelloWorld as printHelloWorldB

fun main() {
    printHelloWorldA()
    printHelloWorldB()

    // 구조분해 문법
    // data 클래스를 생성하면 componentN 함수가 자동으로 생성 된다.
    val person = Person("홍홍", 99)
    val (name, age) = person
    /* 구조분매 문법을 쓴다는 것은 componentN 함수를 호출한다는 뜻
    val name = person.component1()
    val age = person.component2()
     */
    println("이름: $name, 나이: $age")

    // 일반 클래스에서 구조분해 사용하기 예
    val personNoData = PersonNoData("홍홍2", 90)
    val (name2, age2) = personNoData

    // map.entries 도 구조분해 문법을 사용한 코드이다.
    val map = mapOf(1 to "A", 2 to "B")
    for ((key, value) in map.entries) {
    }

    // Label
    // 라벨을 사용한 Jump는 사용하지 않는 것을 추천. 코드 복잡성 증가.
    label@ for (i in 1 .. 100) {
        for (j in 1 .. 100) {
            println(j)
            if (j == 2) {
                // label 을 명시 함으로 명시 된 루프가 종료 된다.
                break@label
            }
        }
    }
}

// TakeIf, TakeUnless
fun getNumberOrNull(number: Int): Int? {
    /*return if (number <= 0) {
        null
    } else {
        number
    }*/

    // TakeIf
    // 주어진 조건을 만족하면 그 값이, 그렇지 않으면 null 이 반환 된다.
    return number.takeIf { it > 0 }

    // TakeUnless
    // 주어진 조건을 만족하면 않으면 그 값이, 그렇지 않으면 null 이 반환된다.
    // return number.takeUnless { it <= 0 }
}

data class Person(
    val name: String,
    val age: Int
)

class PersonNoData(
    val name: String,
    val age: Int
) {
    operator fun component1(): String {
        return this.name
    }

    operator fun component2(): Int {
        return this.age
    }
}