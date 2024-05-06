package jung.demo.studykolininaction.tickets.entity

import com.example.hellospring.util.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
class Tickets(
    @Column(name = "seat_number")
    val seatNumber: String,

    @Column(name = "purchase_status")
    var purchaseStatus: Boolean,

    @Column(name = "purchase_user")
    var purchaseUser: String,
) : BaseEntity() {


    fun buy(name: String, status: Boolean) {
        purchaseStatus = status
        purchaseUser = name
    }

    override fun toString(): String {
        return "Tickets(seatNumber='$seatNumber', purchaseStatus=$purchaseStatus, purchaseUser='$purchaseUser')"
    }


}