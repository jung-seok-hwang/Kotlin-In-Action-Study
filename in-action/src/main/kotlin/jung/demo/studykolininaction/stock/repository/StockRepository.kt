package jung.demo.studykolininaction.stock.repository

import jung.demo.studykolininaction.stock.entity.Stock
import org.springframework.data.jpa.repository.JpaRepository

interface StockRepository : JpaRepository<Stock, Long> {
}