package jung.demo.studykolininaction.stock.repository

import jakarta.persistence.LockModeType
import jung.demo.studykolininaction.stock.entity.Stock
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Lock
import java.util.*

interface StockRepository : JpaRepository<Stock, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    override fun findById(id: Long): Optional<Stock>

}