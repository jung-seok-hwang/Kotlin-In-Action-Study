package jung.demo.studykolininaction.ch8

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class HigherOrderFunctionsProblemsTest {

    /*
    * If the number is less than 5, then multiply the number by 3. If the number is greater than or equal to 5, subtract 2 from the number.
    * */
    @Test
    @DisplayName("숫자가 5보다 작으면, 그 숫자에 3을 곱합니다. 숫자가 5 이상이면, 그 숫자에서 2를 빼세요.")
    fun higherOrderFunctionsProblems1() {

        val numbers = listOf(3, 5, 8, 1, 7)

        multiply(numbers) {
            when {
                it < 5 -> it * 3
                else -> it - 2
            }
        }
    }

    private fun multiply(array: List<Int>, transform: (Int) -> Int): List<Int> {
        return array.map(transform)
    }


    @Test
    fun nonHigherOrderFunctionsProblems1() {

        val numbers = listOf(3, 5, 8, 1, 7)

        multiply(numbers)
    }

    private fun multiply(array: List<Int>): List<Int> {

        return array.map {
            when {
                it < 5 -> it * 3
                else -> it - 2
            }
        }
    }

    /*
    * 필터링 조건:
    *   숫자가 10 이상이고 20 이하이면 선택합니다.
    * 변환 조건:
    *   선택된 숫자가 짝수이면, 그 숫자를 2로 나눕니다.
    *   선택된 숫자가 홀수이면, 그 숫자에 3을 더합니다.
    *
    * */
    @Test
    fun filterAndTransform1() {
        val numbers = selectAndTransformRange(listOf(5, 10, 15, 20, 25, 30)) {
            when {
                it % 2 == 0 -> it / 2
                it % 3 == 0 -> it + 3
                else -> it
            }
        }

        numbers.forEach(System.out::println)
    }

    private fun selectAndTransformRange(array: List<Int>, transform: (Int) -> Int): List<Int> {

        return array.filter { arrays -> arrays in 10..20 }.map(transform)
    }


}