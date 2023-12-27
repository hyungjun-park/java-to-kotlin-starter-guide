package com.lannstark.lec17

fun main() {
    val fruits = listOf(
        Fruit("사과", 1000),
        Fruit("사과", 1200),
        Fruit("사과", 1200),
        Fruit("사과", 1500),
        Fruit("바나나", 3000),
        Fruit("바나나", 3200),
        Fruit("바나나", 2500),
        Fruit("수박", 10000)
    )

    // 코틀린에서는 함수가 1급 시민으로 변수, 파라미터에 넣을 수 있다.
    // 코틀린에서의 람다 예
    val isApple = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }
    // 람다의 마지막 줄의 결과가 반환값
    val isApple2 = { fruit: Fruit -> fruit.name == "사과"}

    // 람다 사용 예
    isApple(fruits[0])
    isApple.invoke(fruits[1])


    filterFruits(fruits, isApple)
    // 함수의 마지막 파라미터가 함수인 경우 소괄호 밖에 람다 사용이 가능
    filterFruits(fruits) { it.name == "사과" }

    // Closure
    // Java 에서는 람다를 쓸 때 사용할 수 있는 변수에 제역이 있음. 아래의 경우 에러 사용 불가
    // 코틀린에서는 람다가 시작하는 지점에 참조하고 있는 변수들을 모두 포획하여 그 정보를 가지고 있어 문제 없이 동작한다.
    // 이 데이터 구조를 Closure 라고 한다. (람다가 실행되는 시점에 쓰고 있는 변수들을 모두 포획한 데이터 구조)
    var targetFruitName = "바나나"
    targetFruitName = "수박"
    val results = filterFruits(fruits) {it.name == targetFruitName}
    results.forEach { println(it.name) }
}

private fun filterFruits(
    fruits: List<Fruit>,
    filter: (Fruit) -> Boolean
): List<Fruit> {
    val results = mutableListOf<Fruit>()
    for (fruit in fruits) {
        if (filter(fruit)) {
            results.add(fruit)
        }
    }
    return results
}