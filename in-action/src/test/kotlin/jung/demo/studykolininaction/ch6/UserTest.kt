package jung.demo.studykolininaction.ch6

import jdk.jshell.execution.Util
import org.junit.jupiter.api.Test

class UserTest {


    @Test
    fun lambda_sum() {

        val users = listOf(User("userA", 25), User("userB", 30), User("userC", 10))

        val name = users.joinToString(separator = "",
            transform = { user ->
                user.name
            })

        println(name)


        val youngestUserAge = users.minOfOrNull { user -> user.age }

        val minimumAgeUsingIt = users.minOfOrNull { it.age }

        println(youngestUserAge)

        println(minimumAgeUsingIt)
    }

    fun printProblem(response: Collection<String>) {

        var clientErrors = 0
        var serverErrors = 0

        response.forEach {
            clientErrors++
            serverErrors++
        }
    }

    @Test
    fun lambda_message() {
        var baseNumber : Int = 0
        val runSomething = RunSomething {

            number ->
            baseNumber++
            number + baseNumber
        }
        println(runSomething.doIt(5))
    }


}