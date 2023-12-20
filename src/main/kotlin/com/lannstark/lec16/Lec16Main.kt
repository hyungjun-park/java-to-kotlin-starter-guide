package com.lannstark.lec16

fun main() {
    val str = "ABC"
    println(str.lastChar()) // C

    val person = Person("H", "GD", 19)
    // 멤버 함수를 우선 호출
    println(person.nextYearAge())

    // infix 함수 호출
    // 중위 함수 - '변수 함수이름 argument'
    2.add(3) // 일반
    2 add 3 // 중위 함수

    5.add2(3)
}

// 확장 함수
// 확장대상클래스.함수이름(파라미터): 리턴타입
fun String.lastChar(): Char {
    return this[this.length - 1]
}

// 멤버 함수가 존재하는 함수의 확장 함수 작성 예시
fun Person.nextYearAge(): Int {
    println("확장 함수")
    return this.age + 1
}

// infix 함수
infix fun Int.add(other: Int): Int {
    return this + other
}

// inline 함수
// 함수가 호출되는 대신 함수를 호출한 지점에 함수 본물을 그대로 복붙하고 싶은 경우
inline fun Int.add2(other: Int): Int {
    return this + other
}

// 지역 함수
fun createPerson(firstName: String, lastName: String): Person {
    fun validateName(name: String, fieldName: String) {
        if (name.isEmpty()) {
            throw IllegalArgumentException("${fieldName}은 비어있을 수 없습니다.")
        }
    }
    validateName(firstName, "firstName")
    validateName(lastName, "lastName")

    return Person(firstName, lastName, 1)
}