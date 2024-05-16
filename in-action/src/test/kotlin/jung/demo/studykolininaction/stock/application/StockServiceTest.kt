package jung.demo.studykolininaction.stock.application

import jung.demo.studykolininaction.stock.application.StockService
import jung.demo.studykolininaction.stock.entity.Stock
import jung.demo.studykolininaction.stock.repository.StockRepository
import org.apache.catalina.Executor
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.locks.ReentrantLock
import kotlin.test.assertEquals


@SpringBootTest
class StockServiceTest @Autowired constructor(
    private val stockService: StockService,
    private val stockRepository: StockRepository,
) {


    @BeforeEach
    fun before() {
        stockRepository.saveAndFlush(Stock(1L, 100L))
    }

    @AfterEach
    fun after() {
        stockRepository.deleteAll()
    }

    @Test
    @DisplayName("재고 감소")
    fun inventory_reduction() {

        stockService.decrease(1L, 1L)

        val stock = stockRepository.findById(1L).orElseThrow()

        assertEquals(99, stock.quantity)

    }

    @Test
    @DisplayName("동시에 100개의 요청")
    fun requestsAtTheSameTime() {
        val threadCount = 100
        val executorService = Executors.newFixedThreadPool(32)
        val latch = CountDownLatch(threadCount)

        for (i in 0 until threadCount) {
            executorService.submit {
                try {
                    stockService.decrease(1L, 1L)
                } finally {
                    latch.countDown()
                }
            }
        }
        latch.await()

        val stock = stockRepository.findById(1L).orElseThrow { NoSuchElementException("Stock not found!") }
        assertEquals(0, stock.quantity)
    }

    @Test
    @DisplayName("(동시에 100개의 요청) synchronized 적용해 동시 요청 처리")
    fun requestsAtTheSameTimeSynchronized() {
        val lock = ReentrantLock()
        val threadCount = 100
        val executorService = Executors.newFixedThreadPool(32)
        val latch = CountDownLatch(threadCount)

        for (i in 0 until threadCount) {
            executorService.submit {
                try {
                    stockService.synchronized(1L, 1L)
                } finally {
                    latch.countDown()
                }
            }
        }
        latch.await()

        val stock = stockRepository.findById(1L).orElseThrow { NoSuchElementException("Stock not found!") }
        assertEquals(0, stock.quantity)
    }

    @Test
    @DisplayName("(동시에 100개의 요청) write_lock 적용해 동시 요청 처리")
    fun write() {
        val threadCount = 100
        val executorService = Executors.newFixedThreadPool(32)
        val latch = CountDownLatch(threadCount)

        for (i in 0 until threadCount) {
            executorService.submit {
                try {
                    stockService.write(1L, 1L)
                } finally {
                    latch.countDown()
                }
            }
        }
        latch.await()

        val stock = stockRepository.findById(1L).orElseThrow { NoSuchElementException("Stock not found!") }
        assertEquals(0, stock.quantity)
    }

}