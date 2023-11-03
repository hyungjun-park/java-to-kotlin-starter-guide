package com.lannstark.lec02


fun main() {

    // Safe Call(?,) null 이 아닌 경우 뒷 부분을 실행 아니면 null
    val str: String? = "A"
    println(str?.length)

    // Elvis 연산자(?:) 앞의 연산 결과가 null 이면 뒤의 값을 사용
    val str2: String? = null
    println(str2?.length ?: 0) // 결과는 0

    // 플랫폼 타입
    // kotlin에서 Java 코드를 가져다 사용할 때 null 관련 어노테이션을 인식하여 null 여부를 확인한다.
    // ex) javax.annotation, org.jetbrains.annotation
    // null 관련 정보를 알 수 없는 경우라면 Runtime 시 Exception 이 발생 할 수 있다.
    val person = Person(null)
    startsWithA(person.name) // Java 코드에서 @Nullable 이라면 타입 불일치로 알려 준다.
}

fun startsWithA(str: String): Boolean {
    return str.startsWith("A")
}

fun startsWithA1(str: String?): Boolean {
    /*if (str == null) {
        throw IllegalArgumentException("null이 들어왔습니다.")
    }
    return str.startsWith("A")*/

    return str?.startsWith("A") ?: throw IllegalArgumentException("null이 들어왔습니다.")
}

fun startsWithA2(str: String?): Boolean? {
    /*if (str == null) {
        return null;
    }
    return str.startsWith("A")*/

    return str?.startsWith("A")
}

fun startsWithA3(str: String?): Boolean {
    /*if (str == null) {
        return false
    }
    return str.startsWith("A")*/

    return str?.startsWith("A") ?: false
}

fun startsWith(str: String?): Boolean {
    // null 허용 이지만 변수가 null이 아님을 단언 !!
    // !! 사용한 경우 해당 값으로 null 이 들어온다면 NPE 발생
    // 정말 null이 아닌게 확실한 경우에만 사용해야 한다
    return str!!.startsWith("A")
}