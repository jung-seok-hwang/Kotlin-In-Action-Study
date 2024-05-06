package jung.demo.studykolininaction.tickets

import jung.demo.studykolininaction.ch6.RunSomething
import jung.demo.studykolininaction.ch6.User
import org.junit.jupiter.api.Test

class KotlinLambdaTest {

    @Test
    fun lambda_message() {
        var baseNumber: Int = 0
        val runSomething = RunSomething { number ->
            baseNumber++
            number + baseNumber
        }
        println(runSomething.doIt(5))
    }

    @Test
    fun 술어() {

        val people = listOf(User("userA", 28), User("userB", 29))

        val filter = people.filter(::findByUserAge).map(User::name)

        println("결과값 = $filter")
    }

    @Test
    fun 가장나이가_많은_사용자() {

        val people = listOf(User("userA", 28), User("userB", 29))

        val maxByOrNull = people.maxBy { it.age }
        println("ByOrNull Result : $maxByOrNull")

        val let = maxByOrNull.let { u ->
            people.filter {
                it.age == u.age
            }.map(User::age)
        }

        println("let Result : $let")

        val maxOfOrNull = people.maxOfOrNull { it.age }
        println("OfOrNull Result : $maxOfOrNull")
    }


    private fun findByUserAge(u: User): Boolean {

        return u.age <= 25
    }

}