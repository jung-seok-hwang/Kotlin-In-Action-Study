package jung.demo.studykolininaction.stock.application

import jakarta.transaction.Transactional
import jung.demo.studykolininaction.stock.repository.StockRepository
import org.springframework.stereotype.Service

@Service
class StockService (
    private val stockRepository: StockRepository
) {

    @Transactional
    fun decrease(id: Long, quantity: Long) {
        val stock = stockRepository.findById(id).orElseThrow()

        stock.decrease(quantity)

        stockRepository.saveAndFlush(stock)
    }
}