package com.lannstark.lec12

fun main() {
    // 코틀린의 익명클래스
    moveSomething(object : Movable{
        override fun fly() {
            TODO("Not yet implemented")
        }

        override fun move() {
            TODO("Not yet implemented")
        }
    })
}

class Person constructor(
    private var name: String,
    private var age: Int
) {

    // 코틀린은 static 이 없음
    // companion object 를 사용 (클래스와 동행하는 유일한 오브젝트)
    companion object Factory : Log {
        private const val MIN_AGE = 1

        // @JvmStatic // Java 에서 사용 시 static 처럼 사용할 수 있다.
        fun newBaby(name: String): Person {
            return Person(name, MIN_AGE)
        }

        override fun log() {
            println("나는 Person 클래스의 동행객체 Factory~")
        }
    }
}

// 코틀린의 싱글톤
object Singleton {
    var a: Int = 0
}

private fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}