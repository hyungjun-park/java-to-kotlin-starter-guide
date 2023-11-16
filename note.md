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