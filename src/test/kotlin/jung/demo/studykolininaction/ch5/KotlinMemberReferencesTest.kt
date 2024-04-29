package jung.demo.studykolininaction.ch5

import jung.demo.studykolininaction.ch6.User
import org.junit.jupiter.api.Test

class KotlinMemberReferencesTest {

    @Test
    fun meta() {

        val people = listOf(User("userA", 28), User("userB", 29))

//        val filter = people.filter(::canBeInClub).map(User::name)
        val filter = people.filter { user -> canBeInClub(user.age) }.map(User::name)

//        val filter = people.filter { user -> user.age <= 25 }.map(User::name)

        println(filter)
    }

    private fun canBeInClub(u:Int): Boolean {
//        return u.age <= 25
        return u <= 25
    }
}