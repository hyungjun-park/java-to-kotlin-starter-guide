package com.lannstark.lec18



fun main() {
    val fruits = listOf(
        Fruit(1, "사과", 1000, 1500),
        Fruit(2, "사과", 1200, 1700),
        Fruit(3, "사과", 1200, 1700),
        Fruit(4, "사과", 1500, 2000),
        Fruit(5, "바나나", 3000, 3200),
        Fruit(6, "바나나", 3200, 3400),
        Fruit(7, "바나나", 2500, 3000),
        Fruit(8, "수박", 10000, 11000)
    )

    // 컬렉션을 함수형으로 다루는 방법
    // filter
    val apples = fruits.filter { fruit -> fruit.name == "사과" }
    // filter 에서 index
    val apples2 = fruits.filterIndexed { index, fruit ->
        println(index)
        fruit.name == "사과"
    }
    // map
    val applePrices = fruits.filter { fruit -> fruit.name == "사과" }
        .map { fruit -> fruit.factoryPrice }
    // map 에서 index
    val appliePrices2 = fruits.filter { fruit -> fruit.name == "사과" }
        .mapIndexed { index, fruit ->
            println(index)
            fruit.factoryPrice
        }

    // 다양한 컬렉션 처리 기능
    // all: 조건을 모두 만족하면 true 그렇지 않으면 false
    val isAllApple = fruits.all { it.name == "사과" }
    // none: 조건을 모두 불만족하면 true 그렇지 않으면 false
    val isNoApple = fruits.none { it.name == "사과" }
    // any: 족선을 하나라도 만족하면 true 그렇지 않으면 false
    val isNoApple2 = fruits.any { it.factoryPrice >= 10_000 }
    // count: 개수를 센다
    val fruitCount = fruits.count()
    // sortedBy: (오름차순) 정렬을 한다
    val sortedFruits = fruits.sortedBy { it.factoryPrice }
    // 내림 차순
    val sortedFruits2 = fruits.sortedByDescending { it.factoryPrice }
    // distinctBy: 변형된 값을 기준으로 중복을 제거한다.
    val distinctFruitNames = fruits.distinctBy { it.name }
        .map { it.name }
    // first: 첫번째 값을 가져온다 (무조건 null이 아니어야함. null 이면 Exception 발생)
    // firstOrNull: 첫번째 값 또는 null을 가져온다.
    fruits.first()
    fruits.firstOrNull()
    // last: 마지막 값을 가져온다 (null 인 경우 Exception 발생
    // lastOrNull: 마지막 값 또는 null을 가져온다.
    fruits.last()
    fruits.lastOrNull()

    // List를 Map으로
    // 과일이름 -> List<과일> Map이 필요하다?
    val map: Map<String, List<Fruit>> = fruits.groupBy { it.name }
    // it -> 과일 Map이 필요하다?
    // val map2: Map<Long, Fruit> = fruits.associateBy { it.id }

    // 과일이름 -> List<가격> Map 이 필요하다
    val map3: Map<String, List<Long>> = fruits.groupBy({it.name}, {it.factoryPrice})

    // 중첩된 컬렉션 처리
    val fruitsInList: List<List<Fruit>> = listOf(
        listOf(
            Fruit(1, "사과", 1000, 1000),
            Fruit(2, "사과", 1200, 1700),
            Fruit(3, "사과", 1200, 1700),
            Fruit(4, "사과", 1500, 2000),
        ),
        listOf(
            Fruit(5, "바나나", 3000, 3200),
            Fruit(6, "바나나", 3200, 3400),
            Fruit(7, "바나나", 2500, 3000),
            Fruit(8, "수박", 10000, 11000)
        ),
        listOf(
            Fruit(8, "수박", 10000, 10000)
        )
    )

    // 출고가와 현재가가 동일한 과일을 골라주세요
    val samePriceFruits = fruitsInList.flatMap { list ->
        list.filter { it.factoryPrice == it.currentPrice }
    }
    // 리펙토링
    val samePriceFruits2 = fruitsInList.flatMap { it.samePriceFilter }

    // List<List<Fruit>> 을 List<Fruit>로 변경
    fruitsInList.flatten()
}

val List<Fruit>.samePriceFilter: List<Fruit>
    get() = this.filter(Fruit::isSamePrice)

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

private fun filterFruitsLambda(
    fruits: List<Fruit>,
    filter: (Fruit) -> Boolean
): List<Fruit> {
    return fruits.filter(filter)
}

data class Fruit(
    val id: Long,
    val name: String,
    val factoryPrice: Long,
    val currentPrice: Long,
) {
    val isSamePrice: Boolean
        get() = factoryPrice == currentPrice
}