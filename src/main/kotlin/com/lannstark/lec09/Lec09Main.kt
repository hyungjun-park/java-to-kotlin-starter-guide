package com.lannstark.lec09

fun main() {
    val person = Person("홍길동", 120)
    println(person.name)
    person.age = 300
    println(person.age)

    // Java 클래스에 대해서도 .필드로 getter, setter 를 사용할 수 있다.
    val javaPerson = JavaPerson("자길동", 100)
    println(javaPerson.name)
    javaPerson.age = 500
    println(javaPerson.age)
}

class Person( // 주 생성자
    name: String,
    var age: Int // getter 를 포함
) {
    var name: String = name
        // custom getter
        get() = field.uppercase() // field는 자기 자신을 가르치는 예약어 (backing field)
        // name.uppercase 할 경우 name -> get -> name -> get 무한 루프에 빠진다.
        set(value) {
            field = value.uppercase()
        }

    // init 블록: 이 클래스가 초기화되는 시점에 한 번 호출되는 블록
    // 클래스가 생성되는 시점에 무언가 검증 로직을 해주고 싶다면 init 블록을 사용한다.
    init {
        if (age <= 0) {
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
        }
        println("초기화 블록")
    }

    // 부 생성자
    // 코클린에서는 부생성자 보단 default parameter 사용을 권장 한다.
    constructor(name: String): this(name, 1)
    constructor(): this("홍길동") {
        println("부생성자 2")
    }

    // 성인인지 확인하는 함수 작성의 2가지 (함수, custom getter)
    // 함수
    /*fun isAdult(): Boolean {
        return this.age >= 20
    }*/
    // Custom getter
    val isAdult: Boolean
        get() = this.age >= 20
}

// constructor 생략 가능
// 생성자에서 바로 프로퍼티를 선언할 수 있다.
class OriginPerson constructor(name: String, age: Int) {
    val name = name
    var age = age
}