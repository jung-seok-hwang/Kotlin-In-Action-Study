package jung.demo.studykolininaction.stock.entity

import com.example.hellospring.util.BaseEntity
import jakarta.persistence.Entity

@Entity
class Stock(
    var productId: Long,
    var quantity: Long
): BaseEntity() {

    fun decrease(quantity: Long) {
        if (this.quantity - quantity < 0) {
            throw RuntimeException("재고는 0개 미만이 될수없습니다.")
        }
        this.quantity -= quantity
    }

}