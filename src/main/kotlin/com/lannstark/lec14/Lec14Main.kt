package com.lannstark.lec14

fun main() {

}

// data class
// data 키워드를 붙여주면 equals, hashCode, toString 을 자동으로 만들어 준다.
data class PersonDto(
    val name: String,
    val age: Int,
)

// enum class
enum class Country(
    private val code: String
) {
    KOREA("KO"),
    AMERICA("US");
}

fun handleCountry(country: Country) {
    when (country) {
        Country.KOREA -> TODO()
        Country.AMERICA -> TODO()
    }
}

// sealed class
sealed class  HyundaiCar(
    val name: String,
    val price: Long,
)

class Avante : HyundaiCar("아반떼", 1_000L)
class Sonata : HyundaiCar("소나타", 2_000L)

fun handleCar(car: HyundaiCar) {
    when (car) {
        is Avante -> TODO()
        is Sonata -> TODO()
    }
}