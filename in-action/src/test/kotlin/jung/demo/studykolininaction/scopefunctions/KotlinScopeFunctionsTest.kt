package jung.demo.studykolininaction.scopefunctions

import jung.demo.studykolininaction.tickets.entity.Member
import org.junit.jupiter.api.Test

class KotlinScopeFunctionsTest {


    @Test
    fun using_the_let_function() {

        Member("Atom", 20, "Korean").let {
            it.moveTo("Japan")
            it.incrementAge()
        }
    }


    @Test
    fun not_using_the_let_function() {

        val atom = Member("Atom", 20, "Korean")

        atom.moveTo("Japan")
        atom.incrementAge()

    }

}