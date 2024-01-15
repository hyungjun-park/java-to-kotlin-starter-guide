# 01. 코틀린에서 변수를 다루는 방법
- 모든 변수는 var/val을 붙여 주어야 한다.
    - var: 변경 가능하다
    - val: 변경 불가능하다 (read-only)
- 타입을 명시적으로 작성하지 않아도 타입이 추론된다.
- Primitive Type과 Reference Type을 구분하지 않아도 된다.
- Null이 들어갈 수 있는 변수는 타입 뒤에 ?를 붙여주어야 한다.
    - 아예 다른 타입으로 간주된다.
- 객체를 인스턴스화 할 때 new를 붙이지 않아야 한다.

# 02. 코틀린에서 null을 다루는 방법
- 코틀린에서 null 이 들어갈 수 있는 타입은 완전히 다르게 간주된다.
    - 한 번 null 검사를 하면 non-null 임을 컴파일러가 알 수 있다.
- null 이 아닌 경우에만 호출되는 Safe Call (?.) 이 있다.
- null 인 경우에만 호출되는 Elvis 연산자 (?:) 가 있다.
    - 이름이 Elvis 인 이유는 연산자를 90도 돌리면 Elvis 머리스타일을 닮아서 란다.
- null 이 절대 아닐때 사용할 수 있는 널 아님 단언 (!!) 이 있다.
- 코틀린에서 Java 코드를 사용할 때 플랫폼 타입 사용에 유의해야 한다.
    - Java 코드를 읽으며 null 가능성 확인 (null 관련 어노테이션)

# 03. 코틀린에서 Type을 다루는 방법

## 기본 타입
- Byte
- Short
- Int
- Long
- Float
- Double
```kotlin
// 코틀린에서는 선언된 기본값을 보고 타입을 추론한다.
val number1 = 3 // Int
var number2 = 3L // Long
val number3 = 3.0f // Float
val number4 = 3.0 // Double

// Java 와 다른 내용
// Java - 기본 타입간의 변환은 암시적으로 이루어질 수 있다.
// Kotlin - 기본 타입간의 변환은 명시적으로 이루어져야 한다.

/* Java
// Java에서는 더 큰 타입으로는 암시적으로 변경
int number1 = 4;
long number2 = number1; // 타입 변환

System.out.println(number1 + number2); // long 타입으로 변환
*/
val number5 = 4
// val number2: Long = number1 // Type mismatch Error
val number6: Long = number1.toLong()
```
## 특이한 타입 3가지
1. Any
    - Java의 Object 역할 (모든 객체의 최상위 타입)
    - 모든 Primitive Type의 최상의 타입도 Any
    - Any 자체로는 null을 포함할 수 없어 null을 포함하고 싶다면 Any?로 표현
    - Any 에 equals / hashCode / toString 존재 (Java의 Object와 동일)
2. Unit
    - Unit은 Java의 void와 동일한 역할
    - void와 다르게 Unit은 그 자체로 타입 인자로 사용 가능하다.
    - 함수형 프로그래밍에서 Unit은 단 하나의 인스턴스만 갖는 타입을 의미.   
      즉, 코틀린의 Unit은 실제 존재하는 타입이라는 것을 표현
3. Nothing
    - Nothing은 함수가 정상적으로 끝나지 않았다는 사실을 표현하는 역할
    - 무조건 예외를 반환하는 함수 / 무한 루프 함수

## 정리
- 코틀린의 변수는 초기값을 보고 타입을 추론하며, 기본 타입들 간의 변환은 명시적으로 이루어진다.
- 코틀린에서는 is, !is, as, as? 를 이용해 타입을 확인하고 캐스팅한다.
- 코틀린의 Any는 Java의 Object와 같은 최상위 타입이다.
- 코틀린의 Unit은 Java의 void와 동일하다.
- 코틀린에 있는 Nothing은 정상적으로 끝나지 않는 함수의 반환을 의미한다. (실무에서는 사용이 거의 없다.)

# 04. 코틀린에서 연산자를 다루는 방법
- 단항연산자, 산술연산자, 산술대입연산자 Java와 똑같다.
- 비교 연산자 사용법도 Java와 똑같다.
    - 단, 객체끼리도 자동 호출되는 compareTo를 이용해 비교 연산자를 사용할 수 있다.
- in, !in / a..b / a[i] / a[i] = b 와 같이 코틀린에서 새로 생긴 연산자도 있다.
- 객체끼리의 연산자를 직접 정의할 수 있다.

# 05. 코틀린에서 제어문을 다루는 방법
## if-else
Java와 문법이 동일하다.   
Java 에서 if-else는 **Statement**이지만,   
Kotlin에서는 **Expression**이다. (3항 연산자가 없다)
- Statement : 프로그램의 문장, 하나의 값으로 도출되지 않는다.
- Expression : 하나의 값으로 도출되는 문장

```kotlin
val score = 90
val grade = if (score >= 50) {
    "P"
} else {
    "F"
}
// 코틀린에서는 if-else 가 Expression으로 사용할 수 잇기 때문에 3항 연산자가 없다.
// Java에서는 위와 같은 경우 3항 연산자를 사용하면 된다.
```

## switch 와 when
Java의 switch는 Kotlin에서 when으로 대체되었다.
```kotlin
/*
when (값) {
    조건부 -> 어떠한 구문
    조건부 -> 어떠한 구문
    else -> 어떠한 구문
}
 */
fun getGradeWithSwitch(score: Int): String {
    return when (score / 10) {
        9 -> "A"
        8 -> "B"
        7 -> "C"
        else -> "D"
    }
}

fun getGradeWithSwitch2(score: Int): String {
    return when (score) {
        in 90..99 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "D"
    }
}
```

# 06. 코틀린에서 반복문을 다루는 방법
- for each 문에서 Java 는 : Kotlin 은 in 을 사용한다.
- 전통적인 for문에서 Kotilin 은 등차수열과 in 을 사용한다.
- 그 외 for문 문법은 동일하다.
- while 문과 do while 문은 Java와 동일하다.

# 07. 코틀린에서 예외를 다루는 방법
- try catch finally 구문은 문법적으로 동일하다.
    - Kotlin에서는 try catch가 expression이다.
- Kotlin에서 모든 예외는 Unchecked Exception이다.
- Kotlin에서는 try with resources 구문이 없다. 대신 코틀린의 언어적 특징을 황용해 close를 초출해준다.

# 08. 코틀린에서 함수를 다루는 방법
- 함수의 문법은 Java와 다르다.   
  접근시지어 fun 함수이름(파라미터): 반환타입 {   
  }
- body가 하나의 값으로 간주되는 경우 block{}을 없앨 수도 있고   
  block이 없다면 반환 타입을 없앨 수도 있다.
- 함수 파라미터에 기본값을 설정해 줄 수 있다.
- 함수를 호출할 때 특정 파라미터를 지정해 넣어줄 수 있다. (named argument, build의 장점을 가질 수 있다.)
- 가변인자에는 vararg 키워드를 사용하며, 가변인자 함수를 배열로 호출할 때는 *(spread 연산자)를 붙여주어야 한다.

# 09. 코틀린에서 클래스를 다루는 방법
- 코틀린에서는 필드를 만들면 getter와 (필요에 따라) setter가 자동으로 생긴다.
    - 때문에 이를 프로퍼티 라고 부른다.
- 코틀린에서는 주생성자가 필수이다.
- 코틀린에서는 constructor 키워드를 사용해 부생성자를 추가로 만들 수 있다.
    - 단, default parameter나 정적 팩토리 메소드 사용을 추천한다.
- custom getter와 custom setter를 만들 수 있다.
- custom getter, setter 에서 무한루프를 막기 위해 **field**라는 키워드를 사용한다. (backing field)
```kotlin
class Person(
    name: String = "홍길동",
    var age: Int = 1
) {
    var name: String = name
        get() = field.uppercase()
        set(value) {
            field = value.lowercase()
        }
    
    // 부생성자
    constructor(): this("홍부", 100)
}
```

# 10. 코틀린에서 상속을 다루는 방법

- 상속 또는 구현을 할 때 : 을 사용해야 한다.
- 상위 클래스 상속을 구현할 때 생성자를 반드시 호출해야 한다.
- override를 필수로 붙여야 한다.
- 추상 멤버가 아니면 기본적으로 오버라이드가 불가능하다.
    - open 을 사용해 주어야 한다.
- 상위 클래스의 생성자 또는 초기화 블록에서 open 프로퍼티를 사용하면 얘기치 못한 버그가 생길 수 있다.

## 상속 관련 키워드 4가지
1. final : override 를 할 수 없게 한다. **default로 보이지 않게 존재한다.**
2. open : override 를 열어 준다.
3. abstract : 반드시 override 해야 한다.
4. override : 상위 타입을 오버라이드 하고 있다.

# 11. 코틀린에서 접근 제어를 다루는 방법

## Java 와 코틀린의 가시성 제어
|           | Java                        | Kotlin                                |
|-----------|-----------------------------|---------------------------------------|
| public    | 모든 곳에서 접근 가능                | 모든 곳에서 접근 가능              |
| protected | 같은 패키지 또는 하위 클래스에서만 접근 가능   | 선언된 클래스 또는 하위 클래스에서만 접근 가능            |
| default   | 같은 패키지에서만 접근 가능             | internal 로 변경<br/>같은 모듈에서만 접근 가능      |
| private   | 선언된 클래스 내에서만 접근 가능          | 선언된 클래스 내에서만 접근 가능                    |
- protected 에서는 패키지가 빠짐.    
  코틀린에선느 패키지를 namespace를 관리하지 위한 용도로만 사용.   
  가시성 제어에는 사용되지 않는다.
- default 가 없어지고 internal 이 추가 됨. 같은 모듈에서만 접근 가능
  - 모듈 : 한 번에 컴파일 되는 Kotlin 코드
- Kotlin의 기본 접근 지시어는 **public**

## 코틀린 파일의 접근 제어
코틀린은 .kt 파일에 변수, 함수, 클래스 여러개를 바로 만들 수 있다.
- public : 기본값 어디서든 접근할 수 있다.
- protected : 파일(최상단)에는 사용 불가능. (클래스에서 사용 가능하기 때문에)
- internal : 같은 모듈에서만 접근 가능
- private : 같은 파일 내에서만 접근 가능

## 클래스 안의 멤버
- public : 모든 곳에서 접근 가능
- protected : 선언된 클래스 또는 하위 클래스에서만 접근 가능
- internal : 같은 모듈에서만 접근 가능
- private : 선언된 클래스 내에서만 접근 가능
- 생성자의 접근 지시어를 붙이려면, constructor 를 써주어야 한다.
  - 기본 public 이 붙어 있어 생략이 가능. 다른 지시어는 추가해야 한다.

## Java 와 Kotlin 을 함께 사용할 때 주의할 점
- internal 은 바이트 코드 상 public 이 된다.   
때문에 Java 코드에서는 Kotlin 모듈의 internal 코드를 가져올 수 있다.
- Kotlin의 protected 와 Java 의 protected 는 다르다.   
Java 는 같은 패키지의 Kotlin protected 멤버에 접근할 수 있다.

# 12. 코틀린에서 object 키워드를 다루는 방법
- Java의 static 변수와 함수를 만드려면 Kotlin에서는 companion object를 사용해야 한다.
- companion object도 하나의 객체로 간주되기 때문에 이름을 붙일 수 있고, 다른 타입을 상속받을 수도 있다.
- Kotlin에서 싱글톤 클래스를 만들 때 object 키워드를 사용한다.
- Kotlin에서 익명 클래스를 만들 때 object : 타입 을 사용한다.

# 13. 코틀린에서 중첩 클래스를 다루는 방법
- 클래스 안에 클래스가 있는 경우 종류는 두가지
  1. (Java기준) static을 사용하는 클래스
  2. (Java기준) static을 사용하지 않는 클래스
- 권장되는 클래스는 static을 사용하는 클래스
- 코틀린에서는 이러한 가이드를 따르기 위해
  - 클래스 안에 기본 클래스를 사용하면 바깥 클래스에 대한 참조가 없고
  - 바깥 클래스를 참조하고 싶다면, inner 키워드를 붙여야 한다.
- 코클린 inner class 에서 바깥 클래스를 참조하려면 **this@바깥클래스**를 사용해야 한다.

# 14. 코틀린에서 다양한 클래스를 다루는 방법
- Kotlin의 **Data class**를 사용하면 equals, hashCode, toString을 자동으로 만들어준다.
- Kotlin의 Enum Class는 Java의 Enum Class와 동일하지만 when과 함께 사용함으로써 큰 장점을 갖게 된다.
- Enum Class보다 유연하지만, 하위 클래스를 제한하는 Sealed Class 역시 when과 함께 주로 사용된다.

# 15. 코틀린에서 배열과 컬렉션을 다루는 방법
- 코틀린에서는 컬렉션을 만들 때도 불변/가변을 지정해야 한다.
- List, Set, Map 에 대한 사용법이 변경, 확장되었다.
- Java와 Kotlin 코드를 섞어 컬렉션을 사용할 때에는 주의해야 한다.
  - Java에서 Kotlin 컬렉션을 가져갈 때는 불변 컬렉션을 수정할 수도 있고, non-nullable 컬렉션에 null을 넣을 수도 있다.
  - Kotlin에서 Java 컬렉션을 가져갈 때는 플랫폼타입을 주의해야 한다.

# 16. 코틀린에서 다양한 함수를 다루는 방법
- Java 코드가 있는 상황에서, Kotlin 코드로 추가 기능 개발을 하기 위해 확장함수와 확장프로퍼티가 등장했다.
- 확장함수는 원본 클래스의 private, protected 멤버 접근이 안된다.
- 멤버함수, 확장함수 중 멤버함수에 우선권이 있다.
- 확장함수는 현재 타입을 기준으로 호출된다.
- Java에서는 static 함수를 쓰는 것처럼 Kotlin의 확장 함수를 쓸 수 있다.
- 함수 호출 방식을 바꿔주는 infix 함수가 존재 한다.
- 함수를 복사-붙여넣기 하는 inline 함수가 존재 한다.
- Kotlin에서는 함수 안에 함수를 선언할 수 있고, 지역함수라고 부른다.
```kotlin
fun main() {
    // infix 함수 호출
    2 add 3
}

// 확장 함수
fun 확장대상클래스.함수이름(파라미터): 리턴타입 {
    // this를 이용해 실제 클래스 안의 값 접근
}

// infix 함수
infix fun Int.add(other: Int): Int {
    return this + other
}
```

# 17. 코틀린에서 람다를 다루는 방법
- 함수는 Java에서 2급 시민이지만, 코틀린에서는 1급 시민이다.
  - 때문에, 함수 자체를 변수에 넣을 수도 있고 파라미텅로 전달할 수도 있다.
- 코틀린에서 함수 타입은 (파라미터 타입, ...) -> 반환타입 이다.
- 코틀린에서 람다는 두 가지 방법으로 만들 수 있고, {} 2번 방법이 더 많이 사용 된다.
- 함수를 호출하며, ㅁ지막 파라미터인 람다를 쓸 때는 소괄호 밖으로 람다를 뺄 수 있다.
- 람다의 마지막 expression 결과는 람다의 반환 값이다.
- 코틀린에서는 Closure를 사용하여 non-final 변수도 람다에서 사용 할 수 있다.
```kotlin
// 람다를 만드는 방법 1
val isApple = fun(fruit: Fruit): Boolean {
    return fruit.name == "사과"
}

// 람다를 만드는 방법 2
val isApple2 = { fruit: Fruit -> fruit.name == "사과" }

// 함수의 마지막 파라미터가 람다인 경우 소괄호 밖으로 람다를 뺄 수 있다.
filterFruits(fruits) { it.name == "사과" }
fun filterFruits(fruits: List<Fruit>, filter: (Fruit) -> Boolean) {
    ...
}

// 람다의 마지막 줄은 반환 값이다.
filterFruits(fruits) { fruit -> 
    println("사과사과~")
    fruit.name == "사과"
}

// Closure
// Java 에서는 람다를 쓸 때 사용할 수 있는 변수에 제역이 있음. 아래의 경우 에러 사용 불가
// 코틀린에서는 람다가 시작하는 지점에 참조하고 있는 변수들을 모두 포획하여 그 정보를 가지고 있어 문제 없이 동작한다.
// 이 데이터 구조를 Closure 라고 한다. (람다가 실행되는 시점에 쓰고 있는 변수들을 모두 포획한 데이터 구조)
var targetFruitName = "바나나"
targetFruitName = "수박"
val results = filterFruits(fruits) {it.name == targetFruitName}
results.forEach { println(it.name) }
```

# 18. 코틀린에서 컬렉션을 함수형으로 다루는 방법
- filter, filterIndexed
- map, mapIndexed
- all: 조건을 모두 만족하면 true 그렇지 않으면 false
- none: 조건을 모두 불만족하면 true 그렇지 않으면 false
- any: 조건을 하나라도 만족하면 true 그렇지 않으면 false
- count: 개수를 센다. size 와 동일
- sortedBy: 오름차순 정렬
- sortedByDescending: 내림 차순 정렬
- distinct: 변형된 값을 기준으로 중복을 제거한다
- first: 첫번재 값을 가져온다 (null인 경우 Exception 발생)
- firstOrNull: 첫번째 값 또는 null
- last: 마지막 값을 가져온다 (null인 경우 Exception 발생)
- lastOrNull: 마지막 값 또는 null
- groupBy: 컬렉션의 요소를 지정된 기준으로 그룹화
- associateBy: 컬렉션의 각 요소를 특정 키에 따라 매칭하여 새로운 맵을 생성
- flatMap: 컬렉션의 각 요소에 대해 변환 함수를 적용하고 그 결과를 하나의 평면화된 리스트로 합쳐줌
- flatten: 중첩된 구조를 평면화하여 단일 레벨의 컬렉션으로 만들어 줌

# 19. 코틀린의 이모저모
- 타입에 대한 별칭을 줄 수 있는 typealias 라는 키워드가 존재한다.
- Import 당시 이름을 바꿀 수 있는 as import 기능이 존재한다.
- 변수를 한 번에 선언할 수 있는 구조분배 기능이 있으며, componentN 함수를 사용한다.
- for, while문과 달리 forEach 에는 break와 continue를 사용할 수 없다.
- takeIf와 takeUnless를 활용해 코드양을 줄이고 method chaning을 활용할 수 있다.