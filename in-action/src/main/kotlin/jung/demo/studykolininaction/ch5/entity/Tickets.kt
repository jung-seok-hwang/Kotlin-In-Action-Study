package jung.demo.studykolininaction.ch5.entity

import com.example.hellospring.util.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jung.demo.studykolininaction.ch5.controller.request.TicketsRequest

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