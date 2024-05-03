package jung.demo.studykolininaction.ch8

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class HigherOrderFunctionsTest {

    @Test
    @DisplayName("Use Lambda filter")
    fun lambdaFilter() {
        val filter = "h1i2g3h4e5r6 o7r8d9e10r f11u12n13c14t15i16o17n18s19".filter {
            it in 'a'..'z'
        }
        println(filter)

        val str = "h1i2g3h4e5r6 o7r8d9e10r f11u12n13c14t15i16o17n18s19"

        val result = str.filter {
            it in 'a'..'z'
        }
    }

    @Test
    @DisplayName("Higher Order Functions filter")
    fun stringFilter() {
        val filter = "h1i2g3h4e5r6 o7r8d9e10r f11u12n13c14t15i16o17n18s19".filters {
            it in 'a'..'z'
        }

        println(filter)

    }

    private fun String.filters(operation: (Char) -> Boolean): String {
        val str = StringBuilder()

        for (index in indices) {
            val element = get(index)
            if (operation(element)) str.append(element)
        }

        return str.toString()

    }

    @Test
    fun apply_to_list() {

        val list = apply_to_list(listOf(3, 7, 9, 10)) { it + it }

        for (i in list) {
            println(i)
        }

    }

    private fun apply_to_list(list: List<Int>, apply: (Int) -> Int): List<Int> {

        return list.map(apply)

    }

    @Test
    fun main() {
        val numbers = listOf(1, 2, 3, 4)
        val doubledNumbers = higherOrderFunctionTransform(numbers) { x -> x * 2 }
        println(doubledNumbers)  // 이 코드는 [2, 4, 6, 8]을 출력해야 합니다.
    }

    private fun higherOrderFunctionTransform(numbers: List<Int>, transform: (Int) -> Int): List<Int> {
        val result = numbers.map {
            index -> index * 2
        }


        val it = numbers.map {
              it * 2
        }

        val higherOrderFunctionResult = numbers.map(transform)

        return result
    }
}