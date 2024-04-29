package jung.demo.studykolininaction.ch5

import org.junit.jupiter.api.Test

class KotlinFilteringTest {

    @Test
    fun non_sequence() {
        val startTime = System.currentTimeMillis()

        try {
            var work = 1
            val words = "The quick brown fox jumps over the lazy dog".split(" ")

            val nonSequenceResult = words.filter {
                println("작업 횟수 : ${work++}")
                it.length > 3
            }.map { it.length }.take(4)

            for (word in nonSequenceResult) {
                println(word)
            }

        } finally {
            val endTime = System.currentTimeMillis()
            val duration = endTime - startTime
            println("Elapsed time: $duration ms")
        }

    }

    @Test
    fun sequence() {

        val startTime = System.currentTimeMillis()
        try {
            var work = 1
            val words = "The quick brown fox jumps over the lazy dog".split(" ")
            val asSequence = words.asSequence()

            val sequence = asSequence.filter {
                println("작업 횟수 : ${work++}")
                it.length > 3
            }.map { it.length }.take(11)

            for (word in sequence) {
                println(word)
            }

        } finally {
            val endTime = System.currentTimeMillis()
            val duration = endTime - startTime
            println("Elapsed time: $duration ms")
        }
    }

}