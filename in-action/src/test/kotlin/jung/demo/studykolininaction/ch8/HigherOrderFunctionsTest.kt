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
}