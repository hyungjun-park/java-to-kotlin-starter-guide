package com.lannstark.lec03

fun main() {
    // 타입 변환
    val number1 = 3
    val number2: Long = number1.toLong() // 타입 변환 메소드

    // nullable 의 경우
    val number3: Int? = 3
    val number4: Long = number3?.toLong() ?: 0L

    printAgeIfPersonNullAble(null)

    // String
    val person = Person("홍홍홍", 10)
    println("이름 : ${person.name}") // ${}로 값을 추가 할 수 있다.

    // 여러 줄의 문자열을 작성해야 할 때 """ 사용
    val withoutIndent =
        """
            AAA
            BBB
            CCC
        """.trimIndent()
    println(withoutIndent)

    // 문자열의 특정 문자 가져오기
    val str = "ABCDEF"
    println(str[0]) // A
    println(str[2]) // C
}

fun printAgeIfPerson(obj: Any) {
    if (obj is Person) { // 타입이 아는 경우 !is
        val person = obj as Person // as Person -> Java의 (Person)
        // as Person 생략이 가능. kotlin의 스마트 캐스트
        println(person.age)
    }
}

fun printAgeIfPersonNullAble(obj: Any?) {
    /*
    as -> value가 Type 이면 타입 캐스팅, 아니면 에러
    as? -> value가 Type 이면 타입 캐스팅, 아니면 null, value 가 null 이면 null
     */
    val person = obj as? Person
    println(person?.age)
}