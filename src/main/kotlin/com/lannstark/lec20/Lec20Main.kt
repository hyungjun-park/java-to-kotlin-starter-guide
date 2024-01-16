package com.lannstark.lec20

import com.lannstark.lec20.Person

fun main() {
    val person = Person("홍홍", 12)
    // let, run = 람다의 결과
    // also, apply = 객체 그 자체

    // let
    // 하나 이상의 함술르 call chain 결과로 호출 할 때
    val strings = listOf("apple", "car")
    strings.map { it.length }
        .first { it > 3 }
        .let { println(it) }
    // non-null 값에 대해서만 code block을 실행 시킬 때
    val str: String? = "apple"
    val length = str?.let {
        println(it.uppercase())
        it.length
    }
    // 일회성으로 제한된 영역에 지역 변수를 만들 때
    val numbers = listOf("one", "two", "three", "four")
    val modifiedFirstItem = numbers.first()
        .let { firstItem ->
            if (firstItem.length >= 5) {
                firstItem
            } else {
                "!$firstItem"
            }
        }.uppercase()
    println(modifiedFirstItem)

    // run 객체
    // 초기화와 반환 값의 계산을 동시에 해야 할 때
    // 객체를 만들어 DB에 바로 저장하고, 그 인스턴스를 활용할 떄
    val personRepository = PersonRepository()
    val person2 = Person("홍홍", 20).run(personRepository::save)

    // apply 특징 : 객체 그 자체가 반환된다
    // 객체 설정을 할 때에 객체를 수정하는 로직이 call chain 중간에 필요할 때
    // Test Fixture 예
    fun createPerson(name: String, age: Int, hobby: String): Person {
        return Person(name = name, age = age)
            .apply {
                this.hobby = hobby
            }
    }

    // also 특징 : 객체 그 자체가 반환된다
    // 객체를 수정하는 로직이 call chain 중간에 필요할 때
    mutableListOf("one", "two", "three")
        .also { println(it) }
        .add("four")
    // 아래와 같은 코드
    val numbers2 = mutableListOf("one", "two", "three")
    println(numbers2)
    numbers2.add("four")

    // with
    // 특정 객체를 다른 객체로 변환해야 하는데, 모듈 간의 의존성에 의해
    // 정적 팩토리 혹은 toClass 함수를 만들기 어려울 때

    // scope function과 가독성
    // 1번 코드
    if (person != null && person.isAdult) {
        showPerson(person)
    } else {
        showError()
    }
    // 2번 코드
    person?.takeIf { it.isAdult }
        ?.let { showPerson(it) }
        ?: showError()
}

fun showPerson(person: Person) {
    println("이름: ${person.name} 나이: ${person.age}")
}

fun showError() {
    println("person Error")
}

fun printPerson(person: Person?) {

    /*if (person != null) {
        println(person.name)
        println(person.age)
    }*/
    // scope function
    // 람다를 사용해 일시적인 영역을 만들고 코드를 더 간결하게 만들거나,
    // method chaning에 활용하는 함수응 scoper function 이라고 한다.
    // let 이 scope function의 한 종류
    person?.let {
        println(it.name)
        println(it.age)
    }
}